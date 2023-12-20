package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminServiceInterface {
    public void approveGymCenter(int gymCentreId,int isApproved);
    void approveGymOwner(int gymOwnerId,int isApprove);
    List<GymCentre> viewPendingGymCentres();
    List<GymOwner> viewPendingGymOwners();
}
