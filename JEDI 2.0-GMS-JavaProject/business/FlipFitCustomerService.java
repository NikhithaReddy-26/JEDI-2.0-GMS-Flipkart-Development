package com.flipkart.gms.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.beans.Gym;
import com.flipkart.gms.beans.Slot;
import com.flipkart.gms.client.PaymentClient;
import com.flipkart.gms.dao.*;
import com.flipkart.gms.beans.Bookings;

public class FlipFitCustomerService implements FlipFitCustomerServiceInterface{

	CustomerRepositoryInterface customerRepository = new CustomerRepository();
	GymRepositoryInterface gymRepository = new GymRepository();
	BookingRepositoryInterface bookingRepository = new BookingRepository();
	SlotRepositoryInterface slotRepository = new SlotRepository();

	PaymentClient paymentClient = new PaymentClient();

	public List<Bookings> viewAllBookings(int customerId)
	{
		return bookingRepository.getBookingListByCustomerId(customerId);
	}

	public String bookSlot(int customerId, int gymCenterId, int slotId, String date, Scanner sc)
	{
		Slot slot = slotRepository.getSlotById(slotId);
		if(slot == null || slot.getGymId() != gymCenterId)
		{
			return "Invalid Gym Id or Slot ID";
		}
		String slotTiming = slot.getTime();
		Bookings booking = bookingRepository.checkBookingByCustomerIdDateTime(customerId,date,slotTiming);
		Gym gym = gymRepository.getGymById(gymCenterId);
		if(booking == null)
		{
			int numBooking = bookingRepository.checkAvailability(gymCenterId,slotId,date);
			int totalSeats = gym.getNoOfSeats();
			if(numBooking == totalSeats)
			{
				return "Unfortunately! Slot is already full";
			}
		}
		else
		{
			if(booking.getGymCenterId() == gymCenterId)
			{
				return "Booking was already done by customer";
			}
			else
			{
				bookingRepository.cancelBooking(booking.getId());
			}
		}
		paymentClient.makePayment(customerId,gym.getAmount(),sc);
		bookingRepository.addBooking(gymCenterId,slotId,customerId,date);
		return "Booking Successful";
	}

	public void createCustomer(String address, String name,String password) {
		customerRepository.addCustomer(address,name,password);
	}

	
	public List<FlipFitCustomer> list(){
		return null;
	}
	public FlipFitCustomer authenticate(String name, String password) {
		List<FlipFitCustomer> customers=customerRepository.getCustomers();
		
		for(int i=0;i<customers.size();i++) {
				if(customers.get(i)!=null&&customers.get(i).getName().equals(name) && customers.get(i).getPassword().equals(password)) {
				return customers.get(i);
			}
		}
		return null;
	}

	public List<Gym> getAllApprovedGym() {
		List<Gym> gymList = gymRepository.getAllGyms();
		List<Gym> approvedGymList = new ArrayList<>();
		for(Gym gym:gymList)
		{
			if(gym.isApproved())
			{
				approvedGymList.add(gym);
			}
		}
		return approvedGymList;
	}

	public String cancelBookingById(int bookingId)
	{
		if(bookingRepository.cancelBooking(bookingId))
		{
			return "Booking Successfully Cancelled";
		}
		return "Invalid Booking Id";
	}
}
