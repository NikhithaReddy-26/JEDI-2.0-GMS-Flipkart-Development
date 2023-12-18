package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Gym;

import java.util.ArrayList;
import java.util.List;

public class GymRepository
{
    public GymRepository()
    {
        Gym gym = new Gym();
        gym.setId(1);
        gym.setGymOwnerId(1);
        gym.setName("ABC Gym");
        gym.setLocation("Bangalore");
        gym.setApproved(true);
        gym.setNoOfSeats(100);
        gym.setAmount(1000);
        gymList.add(gym);
        Gym gym1 = new Gym();
        gym1.setId(2);
        gym1.setGymOwnerId(1);
        gym1.setName("XYZ Gym");
        gym1.setLocation("Bangalore");
        gym1.setApproved(false);
        gym1.setNoOfSeats(100);
        gym1.setAmount(2000);
        gymList.add(gym1);
    }
    private List<Gym> gymList = new ArrayList<>();

    public ArrayList<Gym> getAllGyms()
    {
        return (ArrayList<Gym>) gymList;
    }

    public Gym getGymById(int gymId)
    {
        gymList = getAllGyms();
        for(Gym gym : gymList)
        {
            if(gym.getId() == gymId)
            {
                return gym;
            }
        }
        return null;
    }

    public void registerGym(int ownerId, String gymName, String gymLocation, int seats, double amount)
    {
        Gym gym = new Gym();
        gym.setId(gymList.size()+1);
        gym.setApproved(false);
        gym.setLocation(gymLocation);
        gym.setGymOwnerId(ownerId);
        gym.setAmount(seats);
        gym.setAmount(amount);
        gym.setName(gymName);
        gymList.add(gym);
    }

    public List<Gym> getGymByOwnerId(int ownerId)
    {
        List<Gym> ownerGyms = new ArrayList<>();
        for(Gym gym:gymList)
        {
            if(gym.getGymOwnerId() == ownerId)
            {
                ownerGyms.add(gym);
            }
        }
        return ownerGyms;
    }
}
