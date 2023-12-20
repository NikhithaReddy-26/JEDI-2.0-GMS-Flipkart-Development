package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.sql.Date;
import java.util.List;

public interface GymCentreServiceInterface {

    List<GymCentre> getAllCentresByOwmerId(int gymOwnerId);
    List<GymCentre> getCentresByCity(String city);
    List<Slot> getAvailableSlotsByCentreAndDate(int centreID, Date date);
    void addCenter(GymCentre gymCentre);
    void requestGymCentreApproval(int gymCentreId);
    GymCentre getGymCentreById(int centreID);
}
