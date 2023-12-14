package com.flipkart.gms;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flipkart.gms.beans.Admin;
import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.business.FlipFitCustomerService;
import com.flipkart.gms.business.FlipFitOwnerService;

@SpringBootApplication
public class GmsApplication {

	public static FlipFitCustomerService customerService=new FlipFitCustomerService();
	public static FlipFitOwnerService ownerService=new FlipFitOwnerService();
	public static Admin admin=new Admin();
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		SpringApplication.run(GmsApplication.class, args);
		mainMenu();
		
	}
	public static void mainMenu() {
		System.out.println(" Press 1 for Login");
		System.out.println(" Press 2 for Registration of customer");
		System.out.println(" Press 3 for Update Password");
		System.out.println(" Press 4 for exit");
		
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			login();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
	public static void login() {
		System.out.println("Enter username: ");
		String username=sc.next();
		
		System.out.println("Enter password: ");
		String password=sc.next();
		
		System.out.println("Enter role: ");
		String role=sc.next();
		//System.out.println(role+"1");
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
