package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Slot;

import java.util.ArrayList;
import java.util.List;

public class SlotRepository {
    private List<Slot> gymSlots = new ArrayList<>();
    public SlotRepository()
    {
        Slot slot = new Slot();
        slot.setId(1);
        slot.setTime("5.00");
        slot.setGymId(1);
        gymSlots.add(slot);
        Slot slot1 = new Slot();
        slot1.setGymId(1);
        slot1.setId(2);
        slot1.setTime("6.00");
        gymSlots.add(slot1);
    }
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
}
