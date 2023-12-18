package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Bookings;

import java.util.List;

public interface BookingRepositoryInterface {
    List<Bookings> getBookingListByCustomerId(int customerId);

    Bookings checkBookingByCustomerIdDateTime(int customerId, String date, String slotTiming);

    int checkAvailability(int gymCenterId, int slotId, String date);

    boolean cancelBooking(int bookingId);

    void addBooking(int gymCenterId, int slotId, int customerId, String date);
}
