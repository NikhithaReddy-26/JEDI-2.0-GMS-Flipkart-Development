package com.flipkart.business;

import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymOwner;

import java.util.List;

public class GymOwnerService implements GymOwnerServiceInterface {
    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    public void requestGymOwnerApproval(int gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }

    public List<GymOwner> viewAllGymOwners() {
        return gymOwnerDAO.getGymOwnerList();
    }


//    public Object addGymOwnerDetails() {
//        //takes gymOwner object as input
//        return new Object();
//    }

    public int loginGymOwner(String username,String password){
        return gymOwnerDAO.loginGymOwner(username,password);
    }

    public int registerGymOwner(String userName, String password, String email, String panNumber, String cardNumber) {
        return gymOwnerDAO.registerGymOwner(new GymOwner(userName,email,password,panNumber,cardNumber));
    }

    @Override
    public Boolean checkIfGymOwnerIsApprovedById(int gymOwnerId) {
        return gymOwnerDAO.checkOwnerApproved(gymOwnerId);
    }
}
