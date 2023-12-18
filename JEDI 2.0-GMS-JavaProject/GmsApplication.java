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
		while (true)
		{
			System.out.println(" Press 1 for Login");
			System.out.println(" Press 2 for Registration of customer");
			System.out.println(" Press 3 for Registration of Owner");
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

					customerService.createCustomer(address, name, password1);
					System.out.println("Customer Created Successfully");
					break;
				case 3:
					System.out.println("Enter username: ");
					name=sc.next();

					System.out.println("Enter password: ");
					password1=sc.next();

					System.out.println("Enter address: ");
					address=sc.next();

					System.out.println("Enter email: ");
					String email=sc.next();

					System.out.println("Enter phone number: ");
					long phoneNum = sc.nextLong();

					System.out.println("Enter gst number: ");
					String gstNumber = sc.next();
					ownerService.addOwner(name,password1,address,email,phoneNum,gstNumber);
					System.out.println("Gym Owner Registered Successfully please wait for Admin approval");
					break;
				case 4:
					return;
		}
		}
	}
}
