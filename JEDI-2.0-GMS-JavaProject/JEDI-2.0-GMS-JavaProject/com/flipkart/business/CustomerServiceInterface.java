package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.utils.UserPlan;

import java.sql.Date;
import java.util.List;

public interface CustomerServiceInterface {
    List<GymCentre> getAllGymCenterDetailsByCity(String city);
    List<Slot> getAvailableSlots(int centreID, Date date);
    List<Booking> getCustomerBookings(int customerId);
    boolean bookSlot(String userID, Date date, int slotId, int centreId, int userId);
    void cancelBookingbyID(int bookingID);
    void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    Customer viewMyProfile(String userName);
    boolean isUserValid(String userName, String password);

    List<UserPlan> getCustomerPlan(int userName);

    int getUserId(String userName);
}
