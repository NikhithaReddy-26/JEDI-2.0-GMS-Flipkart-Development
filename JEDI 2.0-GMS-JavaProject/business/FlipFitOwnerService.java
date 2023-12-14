package com.flipkart.gms.business;

import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.repository.OwnerRepository;

public class FlipFitOwnerService {

	OwnerRepository ownerRepository=new OwnerRepository();
	
	public FlipFitOwner authenticate(String name, String password) {
		FlipFitOwner[] owners=ownerRepository.getOwners();
		
		for(int i=0;i<3;i++) {
				if(owners[i]!=null&&owners[i].getName().equals(name) && owners[i].getPassword().equals(password)) {
				return owners[i];
			}
		}
		return null;
	}
}
