package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Slot;

import java.util.List;

public interface SlotRepositoryInterface {
    List<Slot> getAllSlotByGymId(int gymId);

    Slot getSlotById(int slotId);

    List<Slot> getSlotListByTime(String slotTiming);

    void addSlot(int gymId, String time);
}
