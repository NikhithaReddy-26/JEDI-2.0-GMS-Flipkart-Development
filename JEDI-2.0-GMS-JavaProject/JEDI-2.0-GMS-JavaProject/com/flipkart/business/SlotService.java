package com.flipkart.business;

import com.flipkart.DAO.SlotDAO;
import com.flipkart.bean.Slot;

import java.util.List;

public class SlotService implements SlotServiceInterface {
    private static SlotDAO slotDAO = new SlotDAO();
    public List<Slot> getAllSlotsByCentre(int centreID) {
        return slotDAO.getSlotByCentreId(centreID);
    }

    public Slot getSlotByID(int slotID){
        return slotDAO.getSlotById(slotID);
    }

    public Slot getSlotByIDandCentreId(int slotID, int centreId){
        return slotDAO.getSlotByIdandCentreId(slotID,centreId);
    }

    public List<Slot> getSlotList(){
        return slotDAO.getSlotList();
    }

    public void addSlotsForGym(int gymCentreId, List<Slot> slotList){
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for(Slot slot : slotList) {
            slot.setCentreID(gymCentreId);
            slotDAO.addSlot(slot);
        }
    }

    public boolean isSlotValid(int slotID, int centreId){
        return getSlotByIDandCentreId(slotID,centreId) != null;
    }
}
