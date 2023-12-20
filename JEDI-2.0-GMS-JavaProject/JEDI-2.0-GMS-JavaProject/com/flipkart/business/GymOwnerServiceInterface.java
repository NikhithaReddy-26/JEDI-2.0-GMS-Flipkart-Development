package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.List;

public interface GymOwnerServiceInterface {

    void requestGymOwnerApproval(int gymOwnerId);
    List<GymOwner> viewAllGymOwners();
    int loginGymOwner(String userName, String password);

    int registerGymOwner(String userName, String password, String email, String panNumber,String cardNumber);
    Boolean checkIfGymOwnerIsApprovedById(int gymOwnerId);
}
