package com.flipkart.gms.business;

import com.flipkart.gms.beans.Admin;
import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.beans.FlipFitOwner;

public class UserAuthService {
	public static FlipFitCustomerService customerService=new FlipFitCustomerService();
	public static FlipFitOwnerService ownerService=new FlipFitOwnerService();
	public static Admin admin=new Admin();
	public void login(String username,String password,String role) {
			
			if(role=="admin") {
				if(admin.getName()==username&&admin.getPassword()==password) {
				System.out.println(admin);}
				else {
					System.out.println("Wrong Credentials");
				}
			}
			else if(role.equals("customer") ) {
				FlipFitCustomer customer=customerService.authenticate(username, password);
				if(customer==null) {
					System.out.println("wrong credentials");
				}
				else {
					System.out.println(customer);
				}
			}
			else if(role.equals("owner")) {
				FlipFitOwner owner=ownerService.authenticate(username, password);
				if(owner==null) {
					System.out.println("wrong credentials");
				}
				else {
					System.out.println(owner);
				}
			}
			else {
				System.out.println("wrong credentials or role");
			}
			
		}
}
