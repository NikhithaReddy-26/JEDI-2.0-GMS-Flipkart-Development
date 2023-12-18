package com.flipkart.gms.beans;

import java.util.List;

public class Admin {

	private String name;
	private String password;
	private List<BookingRequest> pendingRequests;
	private List<BookingRequest> approvedRequests;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<BookingRequest> getPendingRequests() {
		return pendingRequests;
	}
	public void setPendingRequests(List<BookingRequest> pendingRequests) {
		this.pendingRequests = pendingRequests;
	}
	public List<BookingRequest> getApprovedRequests() {
		return approvedRequests;
	}
	public void setApprovedRequests(List<BookingRequest> approvedRequests) {
		this.approvedRequests = approvedRequests;
	}
	@Override
	public String toString() {
		return "Admin [pendingRequests=" + pendingRequests + ", approvedRequests=" + approvedRequests + "]";
	}
}
