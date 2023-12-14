package com.flipkart.gms.business;

import java.util.List;

import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.repository.CustomerRepository;

public class FlipFitCustomerService {

	CustomerRepository customerRepository=new CustomerRepository();
	public void createCustomer() {
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
		FlipFitCustomer[] customers=customerRepository.getCustomers();
		
		for(int i=0;i<3;i++) {
				if(customers[i]!=null&&customers[i].getName().equals(name) && customers[i].getPassword().equals(password)) {
				return customers[i];
			}
		}
		return null;
	}
}
