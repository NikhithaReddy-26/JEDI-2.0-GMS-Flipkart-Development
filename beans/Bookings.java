package com.flipkart.gms.beans;

import com.flipkart.gms.utils.BookingStatus;
import com.flipkart.gms.utils.PaymentMode;

public class Bookings {

	private int bookingId;
	private BookingStatus bookingStatus;
	private PaymentMode mode;
	private String bookingTime;
	
	public boolean bookSlot() {
		return true;
	}
	
	public void cancelBooking() {
		
	}
	
	public void updateBookingStatus() {
		
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
}
