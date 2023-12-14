package com.flipkart.gms.repository;

import com.flipkart.gms.beans.FlipFitOwner;

public class OwnerRepository {

public static FlipFitOwner[] owners=new FlipFitOwner[3]; 
	
	public FlipFitOwner[] getOwners() {
		FlipFitOwner owner=new FlipFitOwner();
		owner.setName("owner1");
		owner.setPassword("pass789");
		owners[0]=owner;
		return owners;
	}
}
