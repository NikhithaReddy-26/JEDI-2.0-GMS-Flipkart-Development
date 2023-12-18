package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Bookings;
import com.flipkart.gms.beans.Slot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingRepository {
    private List<Bookings> bookingsList = new ArrayList<>();
    private SlotRepository slotRepository = new SlotRepository();
    public BookingRepository()
    {
        Bookings bookings = new Bookings();
        bookings.setId(1);
        bookings.setDate("17-12-2023");
        bookings.setSlotId(1);
        bookings.setGymCenterId(1);
        bookings.setGymCenterId(1);
        bookingsList.add(bookings);
    }

    public List<Bookings> getBookingListByCustomerId(int customerId)
    {
        List<Bookings> customerBooking = new ArrayList<>();
        for(Bookings booking : bookingsList)
        {
            if(booking.getCustomerId() == customerId)
            {
                customerBooking.add(booking);
            }
        }
        return customerBooking;
    }

    public Bookings checkBookingByCustomerIdDateTime(int customerId, String date, String slotTiming)
    {
        for(Bookings booking : bookingsList)
        {
            if(booking.getCustomerId() == customerId && booking.getDate() == date)
            {
                List<Slot> slotListByTiming = slotRepository.getSlotListByTime(slotTiming);
                for(Slot slot : slotListByTiming)
                {
                    if(slot.getTime().equals(slotTiming))
                    {
                        return booking;
                    }
                }
            }
        }
        return null;
    }

    public int checkAvailability(int gymCenterId, int slotId, String date)
    {
        int count = 0;
        for(Bookings booking : bookingsList)
        {
            if(booking.getGymCenterId() == gymCenterId && booking.getSlotId() == slotId && booking.getDate() == date)
            {
                count++;
            }
        }
        return count;
    }

    public boolean cancelBooking(int bookingId)
    {
        Iterator<Bookings> itr = bookingsList.iterator();
        while (itr.hasNext()) {
            Bookings b=itr.next();
            if(b.getId()==bookingId)
            {
                itr.remove();
                return true;
            }
        }
        return false;
    }

    public void addBooking(int gymCenterId, int slotId, int customerId, String date)
    {
        Bookings booking = new Bookings(bookingsList.size()+1,gymCenterId,slotId,customerId,date);
        bookingsList.add(booking);
    }
}
