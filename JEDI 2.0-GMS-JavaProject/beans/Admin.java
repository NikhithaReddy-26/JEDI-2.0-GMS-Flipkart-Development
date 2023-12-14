package com.flipkart.gms.beans;

import java.util.List;

public class Admin {

	private List<BookingRequest> pendingRequests;
	private List<BookingRequest> approvedRequests;
	
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
	
}
