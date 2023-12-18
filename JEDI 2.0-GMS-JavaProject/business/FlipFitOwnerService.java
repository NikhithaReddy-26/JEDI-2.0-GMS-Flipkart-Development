package com.flipkart.gms.business;

import java.util.List;

import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.beans.Slot;
import com.flipkart.gms.dao.OwnerRepository;
import com.flipkart.gms.dao.SlotRepository;

public class FlipFitOwnerService {

	OwnerRepository ownerRepository=new OwnerRepository();
	SlotRepository slotRepository = new SlotRepository();
	
	public FlipFitOwner authenticate(String name, String password) {
		List<FlipFitOwner> owners=ownerRepository.getOwners();
		
		for(int i=0;i<3;i++) {
				if(owners.get(i)!=null&&owners.get(i).getName().equals(name) && owners.get(i).getPassword().equals(password)) {
				return owners.get(i);
			}
		}
		return null;
	}

    public List<Slot> viewAllSlotsByGymId(int gymId)
	{
		return slotRepository.getAllSlotByGymId(gymId);
    }
}
