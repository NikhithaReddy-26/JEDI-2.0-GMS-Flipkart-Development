package com.flipkart.business;

import com.flipkart.DAO.CustomerDAO;
import com.flipkart.DAO.CustomerInterfaceDAO;
import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.UserInvalidException;
import com.flipkart.utils.UserPlan;

import java.sql.Date;
import java.util.List;


import static com.flipkart.constant.Constants.*;

public class CustomerService implements CustomerServiceInterface {

    private CustomerInterfaceDAO customerDAO = new CustomerDAO();
    private GymCentreServiceInterface gymCentreService = new GymCentreService();
    private BookingServiceInterface bookingService = new BookingService();
    private ScheduleServiceInterface scheduleService = new ScheduleService();

    private SlotServiceInterface slotService = new SlotService();

    public List<GymCentre> getAllGymCenterDetailsByCity(String city){
        //takes City (Location) as input and returns List<GymCenter>
        return gymCentreService.getCentresByCity(city);
    }

    public List<Slot> getAvailableSlots(int centreID, Date date){
        //takes centerID and date for input and returns List<Slot>
        return gymCentreService.getAvailableSlotsByCentreAndDate(centreID,date);
    }

    public List<Booking> getCustomerBookings(int customerId){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(customerId);
    }

    public List<UserPlan> getCustomerPlan(int customerId){
        return bookingService.getCustomerPlan(customerId);
    }

    @Override
    public int getUserId(String userName) {
        return customerDAO.getCustomerById(userName).getUserID();
    }

    public boolean bookSlot(String userName, Date date, int slotId, int centreId, int userId){
        if(!slotService.isSlotValid(slotId,centreId)){
            System.out.println(INVALID_SLOT);
            return false;
        }
        int scheduleId = scheduleService.getOrCreateSchedule(slotId,date).getScheduleID();
        //create booking
        boolean isOverlap = bookingService.checkBookingOverlap(userId,date,slotId);
        if(isOverlap) {
            System.out.println(RED_COLOR + "There exists a conflicting booking, First cancel it!!!!" + RESET_COLOR);
            return false;
        }
        bookingService.addBooking(userId, scheduleId);
        return true;
    }



    public void cancelBookingbyID(int bookingID){
        //cancel a booking
        bookingService.cancelBooking(bookingID);
    }

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {
        try {
            customerDAO.registerCustomer(userName,password,email,phoneNumber,cardNumber);
        } catch (RegistrationFailedException e) {
            e.getMessage();
        }

    }

    public Customer viewMyProfile(String userName) {
        return customerDAO.getCustomerById(userName);
    }

    public boolean isUserValid(String userName, String password) {
        try {
            return customerDAO.isUserValid(userName,password);
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
