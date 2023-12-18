package com.flipkart.gms.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.gms.beans.FlipFitCustomer;

public class CustomerRepository implements CustomerRepositoryInterface{

	public static List<FlipFitCustomer> customers=new ArrayList<FlipFitCustomer>(); 
	
	public List<FlipFitCustomer> getCustomers() {
		FlipFitCustomer customer=new FlipFitCustomer();
		customer.setId(1);
		customer.setName("cust1");
		customer.setPassword("pass123");
		customers.add(customer);
		return customers;
	}
	
	public void add(FlipFitCustomer customer) {
		customers.add(customer);
	}
}
