package com.flipkart.gms.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.dao.CustomerRepository;
import com.flipkart.gms.beans.Bookings;

public class FlipFitCustomerService {

	CustomerRepository customerRepository=new CustomerRepository();
	public void createCustomer(int id,String address, String name,String password) {
		FlipFitCustomer customer=new FlipFitCustomer();
		customer.setAddress(address);
		customer.setBookings(new ArrayList<Bookings>());
		customer.setId(id);
		customer.setName(name);
		customer.setPassword(password);
		customerRepository.add(customer);
	}
	
	public void deleteCustomer(int id) {
		System.out.println("Cusomter deleted");
	}
	
	public void updateCustomer(int id) {
		System.out.println("Customer updated");
	}
	
	public List<FlipFitCustomer> list(){
		return null;
	}
	public FlipFitCustomer authenticate(String name, String password) {
		List<FlipFitCustomer> customers=customerRepository.getCustomers();
		
		for(int i=0;i<customers.size();i++) {
				if(customers.get(i)!=null&&customers.get(i).getName().equals(name) && customers.get(i).getPassword().equals(password)) {
				return customers.get(i);
			}
		}
		return null;
	}
	
}
