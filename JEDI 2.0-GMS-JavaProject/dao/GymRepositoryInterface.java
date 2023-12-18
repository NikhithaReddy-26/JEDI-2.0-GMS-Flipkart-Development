package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Gym;

import java.util.ArrayList;
import java.util.List;

public interface GymRepositoryInterface {
    ArrayList<Gym> getAllGyms();

    Gym getGymById(int gymId);

    List<Gym> getGymByOwnerId(int ownerId);

    void registerGym(int ownerId, String gymName, String gymLocation, int seats, double amount);
}
