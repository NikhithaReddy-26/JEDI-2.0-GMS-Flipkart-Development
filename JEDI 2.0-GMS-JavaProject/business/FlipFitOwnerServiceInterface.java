package com.flipkart.gms.business;

import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.beans.Slot;

import java.util.List;

public interface FlipFitOwnerServiceInterface {
    FlipFitOwner authenticate(String name, String password);

    List<Slot> viewAllSlotsByGymId(int gymId);

    void addOwner(String name, String password1, String address, String email, long phoneNum, String gstNumber);
}
