package com.flipkart.gms.dao;

import com.flipkart.gms.beans.FlipFitOwner;

import java.util.List;

public interface OwnerRepositoryInterface {
    List<FlipFitOwner> getOwners();

    FlipFitOwner getGymOwnerById(int gymOwnerId);

    void addOwner(String name, String password1, String address, String email, long phoneNum, String gstNumber);
}
