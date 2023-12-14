package com.flipkart.gms.repository;

import com.flipkart.gms.beans.FlipFitCustomer;

public class CustomerRepository {

	public static FlipFitCustomer[] customers=new FlipFitCustomer[3]; 
	
	public FlipFitCustomer[] getCustomers() {
		FlipFitCustomer customer=new FlipFitCustomer();
		customer.setName("cust1");
		customer.setPassword("pass123");
		customers[0]=customer;
		return customers;
	}
	
}
