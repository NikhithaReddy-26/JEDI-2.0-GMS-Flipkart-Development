package com.flipkart.gms.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.gms.beans.FlipFitOwner;

public class OwnerRepository implements OwnerRepositoryInterface {

	private static List<FlipFitOwner> owners=new ArrayList<FlipFitOwner>();
	public List<FlipFitOwner> getOwners() {
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
