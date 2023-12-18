package com.flipkart.gms.business;

import com.flipkart.gms.beans.Bookings;
import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.beans.Gym;

import java.util.List;
import java.util.Scanner;

public interface FlipFitCustomerServiceInterface {
    List<Bookings> viewAllBookings(int customerId);

    String bookSlot(int customerId, int gymCenterId, int slotId, String date, Scanner sc);

    void createCustomer(String address, String name, String password);

    List<FlipFitCustomer> list();

    FlipFitCustomer authenticate(String name, String password);

    List<Gym> getAllApprovedGym();

    String cancelBookingById(int bookingId);
}
