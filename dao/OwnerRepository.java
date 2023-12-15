package com.flipkart.gms.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.gms.beans.FlipFitOwner;

public class OwnerRepository {

public static List<FlipFitOwner> owners=new ArrayList<FlipFitOwner>(); 
	
	public List<FlipFitOwner> getOwners() {
		FlipFitOwner owner=new FlipFitOwner();
		owner.setName("owner1");
		owner.setPassword("pass789");
		owners.add(owner);
		return owners;
	}
}
