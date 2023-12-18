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

/**
 * Represents services provided to FlipFit customers for gym bookings and management.
 */

public class FlipFitCustomerService implements FlipFitCustomerServiceInterface{

	CustomerRepositoryInterface customerRepository = new CustomerRepository();
	GymRepositoryInterface gymRepository = new GymRepository();
	BookingRepositoryInterface bookingRepository = new BookingRepository();
	SlotRepositoryInterface slotRepository = new SlotRepository();

	PaymentClient paymentClient = new PaymentClient();

	/**
	 * Retrieves all bookings made by a specific customer.
	 *
	 * @param customerId The ID of the customer whose bookings are to be retrieved.
	 * @return A list of bookings made by the specified customer.
	 */

	public List<Bookings> viewAllBookings(int customerId)
	{
		return bookingRepository.getBookingListByCustomerId(customerId);
	}

	/**
	 * Books a slot for a customer at a specific gym on a given date.
	 *
	 * @param customerId  The ID of the customer booking the slot.
	 * @param gymCenterId The ID of the gym center for which the slot is being booked.
	 * @param slotId      The ID of the slot being booked.
	 * @param date        The date for which the slot is being booked.
	 * @param sc          Scanner object for user input.
	 * @return A message indicating the success or failure of the booking attempt.
	 */
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

	/**
	 * Creates a new customer with the provided details.
	 *
	 * @param address  The address of the new customer.
	 * @param name     The name of the new customer.
	 * @param password The password of the new customer.
	 */
	public void createCustomer(String address, String name,String password) {
		customerRepository.addCustomer(address,name,password);
	}

	/**
	 * Lists all customers.
	 *
	 * @return A list of all customers.
	 */
	
	public List<FlipFitCustomer> list(){
		return customerRepository.getCustomers();
	}

	/**
	 * Authenticates a customer based on provided credentials.
	 *
	 * @param name     The name of the customer.
	 * @param password The password of the customer.
	 * @return The authenticated customer or null if authentication fails.
	 */
	public FlipFitCustomer authenticate(String name, String password) {
		List<FlipFitCustomer> customers=customerRepository.getCustomers();
		
		for(int i=0;i<customers.size();i++) {
				if(customers.get(i)!=null&&customers.get(i).getName().equals(name) && customers.get(i).getPassword().equals(password)) {
				return customers.get(i);
			}
		}
		return null;
	}

	/**
	 * Retrieves a list of all approved gym centers.
	 *
	 * @return A list of all approved gym centers.
	 */
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

	/**
	 * Cancels a booking by its ID.
	 *
	 * @param bookingId The ID of the booking to be canceled.
	 * @return A message indicating the success or failure of the cancellation attempt.
	 */
	public String cancelBookingById(int bookingId)
	{
		if(bookingRepository.cancelBooking(bookingId))
		{
			return "Booking Successfully Cancelled";
		}
		return "Invalid Booking Id";
	}
}
