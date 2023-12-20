package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

public interface BookingServiceInterface {
    boolean checkBookingOverlap(int customerId, Date date, int slotId);
    void addBooking(int userId, int scheduleID);
    List<Booking> getBookingByCustomerId(int customerId);
    void cancelBooking(int bookingID);
    List<UserPlan> getCustomerPlan(int customerId);
}
