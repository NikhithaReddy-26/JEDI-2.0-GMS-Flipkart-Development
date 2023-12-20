package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCentreInterfaceDAO {

    List<GymCentre> getAllCentresByOwnerId(int gymOwnerId);
    GymCentre getGymCentreByCentreId(int gymCentreId);
    void addGymCentre(GymCentre centre);
    public List<GymCentre> getPendingGymCentreList();
    public void validateGymCentre(int gymCentreId, int isApproved);
    public void sendCentreApprovalRequest(int gymCentreId);
    public List<GymCentre> getGymCentreListByCity(String city);
}
