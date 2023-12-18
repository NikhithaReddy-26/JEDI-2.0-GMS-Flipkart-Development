package com.flipkart.gms;

import java.util.Scanner;


import com.flipkart.gms.business.*;


public class GmsApplication {

	public static UserAuthServiceInterface userAuth =  new UserAuthService();
	public static FlipFitCustomerServiceInterface customerService=new FlipFitCustomerService();
	public static FlipFitOwnerServiceInterface ownerService=new FlipFitOwnerService();
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {

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
			System.out.println("Enter username: ");
			String username=sc.next();
			
			System.out.println("Enter password: ");
			String password=sc.next();
			
			System.out.println("Enter role: ");
			String role=sc.next();
			
			userAuth.login(username, password, role);
			
			break;
		case 2:
			System.out.println("Enter username: ");
			String name=sc.next();
			
			System.out.println("Enter password: ");
			String password1=sc.next();
			
			System.out.println("Enter address: ");
			String address=sc.next();
			
			System.out.println("Enter id: ");
			int id=sc.nextInt();
			
			customerService.createCustomer(id, address, name, password1);
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
}
