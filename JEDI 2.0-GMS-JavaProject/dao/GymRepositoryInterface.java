package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Gym;

import java.util.ArrayList;

public interface GymRepositoryInterface {
    ArrayList<Gym> getAllGyms();

    Gym getGymById(int gymId);
}
