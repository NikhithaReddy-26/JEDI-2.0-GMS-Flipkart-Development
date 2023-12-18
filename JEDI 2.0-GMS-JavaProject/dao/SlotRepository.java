package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Slot;

import java.util.ArrayList;
import java.util.List;

public class SlotRepository implements SlotRepositoryInterface {
    private static List<Slot> gymSlots = new ArrayList<>();
    public List<Slot> getAllSlotByGymId(int gymId)
    {
        List<Slot> slotById = new ArrayList<>();
        for(Slot slot:gymSlots)
        {
            if(slot.getGymId() == gymId)
            {
                slotById.add(slot);
            }
        }
        return slotById;
    }

    public Slot getSlotById(int slotId)
    {
        for(Slot slot:gymSlots)
        {
            if(slot.getId() == slotId)
            {
                return slot;
            }
        }
        return null;
    }

    public List<Slot> getSlotListByTime(String slotTiming)
    {
        List<Slot> slotListByTime = new ArrayList<>();
        for(Slot slot: gymSlots)
        {
            if(slot.getTime().equals(slotTiming))
            {
                slotListByTime.add(slot);
            }
        }
        return slotListByTime;
    }

    public void addSlot(int gymId, String time)
    {
        Slot slot = new Slot();
        slot.setId(getAllSlotByGymId(gymId).size() + 1);
        slot.setGymId(gymId);
        slot.setTime(time);
        gymSlots.add(slot);
    }
}
