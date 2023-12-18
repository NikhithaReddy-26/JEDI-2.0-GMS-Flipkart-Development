package com.flipkart.gms.dao;

import com.flipkart.gms.beans.FlipFitOwner;

import java.util.List;

public interface OwnerRepositoryInterface {
    List<FlipFitOwner> getOwners();

    FlipFitOwner getGymOwnerById(int gymOwnerId);
}
