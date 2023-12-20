package com.flipkart.DAO;

import com.flipkart.bean.Slot;

import java.util.List;

public interface SlotInterfaceDAO {
    public List<Slot> getSlotList();
    public List<Slot> getSlotByCentreId(int gymCentreId);
    public void addSlot(Slot slot);
    public Slot getSlotById(int slotID);
    public Slot getSlotByIdandCentreId(int slotID, int gymCentreId);
}
