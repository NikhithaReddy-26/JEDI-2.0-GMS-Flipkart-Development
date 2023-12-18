package com.flipkart.gms.business;

import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.beans.Gym;
import com.flipkart.gms.beans.Slot;

import java.util.List;

public interface FlipFitOwnerServiceInterface {
    FlipFitOwner authenticate(String name, String password);

    List<Slot> viewAllSlotsByGymId(int gymId);

    void addOwner(String name, String password1, String address, String email, long phoneNum, String gstNumber);

    FlipFitOwner getOwnerById(int ownerId);

    List<Gym> getAllGymByOwnerId(int ownerId);

    void registerGym(int ownerId, String gymName, String gymLocation, int seats, double amount);

    void addGym(int gymId, String time);

    boolean checkGymApproval(int gymId, int ownerId);
}
