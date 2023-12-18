package com.flipkart.gms.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.gms.beans.FlipFitOwner;

public class OwnerRepository implements OwnerRepositoryInterface {

	private final List<FlipFitOwner> owners=new ArrayList<FlipFitOwner>();
	public List<FlipFitOwner> getOwners() {
		FlipFitOwner owner1=new FlipFitOwner();
		owner1.setId(1);
		owner1.setAddress("Bangalore");
		owner1.setName("owner1");
		owner1.setPassword("pass789");
		owner1.setEmail("owner1@gmail.com");
		owner1.setPhone(9876543);
		owner1.setGstNumber("123456");
		owner1.setApproved(false);
		owners.add(owner1);
		FlipFitOwner owner=new FlipFitOwner();
		owner.setName("Kanika");
		owner.setPassword("abc");
		owner.setApproved(true);
		owner.setEmail("kanika@gmail.com");
		owner.setPhone(9876543);
		owner.setAddress("Bangalore");
		owner.setGstNumber("123456");
		owners.add(owner);
		return owners;
	}

	public FlipFitOwner getGymOwnerById(int gymOwnerId) {
		for(FlipFitOwner owner: owners)
		{
			if(owner.getId() == gymOwnerId)
			{
				return owner;
			}
		}
		return null;
	}

	public void addOwner(String name, String password, String address, String email, long phoneNum, String gstNumber)
	{
		FlipFitOwner flipFitOwner = new FlipFitOwner();
		flipFitOwner.setId(owners.size()+1);
		flipFitOwner.setEmail(email);
		flipFitOwner.setName(name);
		flipFitOwner.setPassword(password);
		flipFitOwner.setApproved(false);
		flipFitOwner.setAddress(address);
		flipFitOwner.setPhone(phoneNum);
		flipFitOwner.setGstNumber(gstNumber);
		owners.add(flipFitOwner);
	}
}
