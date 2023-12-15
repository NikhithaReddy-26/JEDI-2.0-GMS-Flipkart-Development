package com.flipkart.gms.business;

import java.util.List;

import com.flipkart.gms.beans.FlipFitCustomer;
import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.dao.OwnerRepository;

public class FlipFitOwnerService {

	OwnerRepository ownerRepository=new OwnerRepository();
	
	public FlipFitOwner authenticate(String name, String password) {
		List<FlipFitOwner> owners=ownerRepository.getOwners();
		
		for(int i=0;i<3;i++) {
				if(owners.get(i)!=null&&owners.get(i).getName().equals(name) && owners.get(i).getPassword().equals(password)) {
				return owners.get(i);
			}
		}
		return null;
	}
}
