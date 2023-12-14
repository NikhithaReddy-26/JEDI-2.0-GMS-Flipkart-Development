package com.flipkart.gms.beans;

import java.util.List;

public class FlipFitCustomer {

	private int id;
	private String name;
	private String address;
	private String password;
	
	@Override
	public String toString() {
		return "FlipFitCustomer [id=" + id + ", name=" + name + ", address=" + address + ", password=" + password
				+ ", bookings=" + bookings + "]";
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private List<Bookings> bookings;
	
	public List<Bookings> getBookings() {
		return bookings;
	}
	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
