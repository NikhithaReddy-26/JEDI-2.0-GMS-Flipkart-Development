package com.flipkart.gms.business;

import com.flipkart.gms.beans.Admin;
import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.client.AdminClient;
import com.flipkart.gms.client.CustomerClient;
import com.flipkart.gms.client.GymOwnerClient;
import com.flipkart.gms.dao.AdminRepository;
import com.flipkart.gms.dao.AdminRepositoryInterface;

import java.util.ArrayList;

public class UserAuthService implements UserAuthServiceInterface {
	public  FlipFitCustomerServiceInterface customerService=new FlipFitCustomerService();
	public FlipFitOwnerServiceInterface ownerService=new FlipFitOwnerService();
	public AdminRepositoryInterface adminRepository=new AdminRepository();
	private final AdminClient adminClient = new AdminClient();

	private final CustomerClient customerClient = new CustomerClient();

	private final GymOwnerClient gymOwnerClient = new GymOwnerClient();

	public void login(String username,String password,String role) {
			
			if(role.equals("admin")) {
				ArrayList<Admin> adminList = adminRepository.getAdminList();
				for(Admin admin:adminList)
				{
					if(admin.getName().equals(username) && admin.getPassword().equals(password))
					{
						adminClient.adminPage();
						return;
					}
				}
				System.out.println("Invalid Credentials or Role");
			}
			else if(role.equals("customer") ) {
				FlipFitCustomer customer=customerService.authenticate(username, password);
				if(customer==null) {
					System.out.println("wrong credentials");
				}
				else {
					customerClient.customerMenu(customer.getId());
				}
			}
			else if(role.equals("owner")) {
				FlipFitOwner owner=ownerService.authenticate(username, password);
				if(owner==null) {
					System.out.println("wrong credentials for owner");
				}
				else {
					gymOwnerClient.ownerMenu(owner.getId(),owner.isApproved());
				}
			}
			else {
				System.out.println("wrong credentials or role");
			}
			
		}
}
