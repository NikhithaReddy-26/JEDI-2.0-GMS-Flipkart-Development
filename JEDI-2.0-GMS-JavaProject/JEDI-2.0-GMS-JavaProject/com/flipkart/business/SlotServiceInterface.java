package com.flipkart.business;

import com.flipkart.bean.Slot;

import java.util.List;

public interface SlotServiceInterface {
    List<Slot> getAllSlotsByCentre(int centreID);
    Slot getSlotByID(int slotID);
    List<Slot> getSlotList();
    void addSlotsForGym(int gymCentreId, List<Slot> slotList);
    boolean isSlotValid(int slotID,int centreId);
}
