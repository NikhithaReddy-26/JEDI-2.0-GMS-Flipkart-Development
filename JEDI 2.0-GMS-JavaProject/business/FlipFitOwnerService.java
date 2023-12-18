package com.flipkart.gms.business;

import java.util.List;

import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.beans.Gym;
import com.flipkart.gms.beans.Slot;
import com.flipkart.gms.dao.GymRepository;
import com.flipkart.gms.dao.OwnerRepository;
import com.flipkart.gms.dao.SlotRepository;

public class FlipFitOwnerService {

	OwnerRepository ownerRepository=new OwnerRepository();
	SlotRepository slotRepository = new SlotRepository();

	GymRepository gymRepository = new GymRepository();
	
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

    public void registerGym(int ownerId, String gymName, String gymLocation, int seats, double amount)
	{
		gymRepository.registerGym(ownerId,gymName,gymLocation,seats,amount);
    }

	public List<Gym> getAllGymByOwnerId(int ownerId)
	{
		return gymRepository.getGymByOwnerId(ownerId);
	}

	public boolean checkGymApproval(int gymId, int ownerId)
	{
		List<Gym> ownerGym = getAllGymByOwnerId(ownerId);
		for(Gym gym: ownerGym)
		{
			if(gym.getId() == gymId)
			{
				return gym.isApproved();
			}
		}
		return false;
	}

	public void addGym(int gymId, String time)
	{
		slotRepository.addSlot(gymId,time);
	}

	public FlipFitOwner getOwnerById(int ownerId)
	{
		return ownerRepository.getGymOwnerById(ownerId);
	}
}
