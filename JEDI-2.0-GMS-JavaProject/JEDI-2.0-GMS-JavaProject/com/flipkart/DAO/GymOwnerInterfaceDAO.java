package com.flipkart.DAO;

import com.flipkart.bean.GymOwner;

import java.util.List;

public interface GymOwnerInterfaceDAO {

    public List<GymOwner> getGymOwnerList();
    public void setGymOwnerList(List<GymOwner> gymOwnerList);
    public int registerGymOwner(GymOwner gymOwner);
    public List<GymOwner> getPendingGymOwnerList();
    public void sendOwnerApprovalRequest(int gymOwnerId);
    public void setPendingGymOwnerList();
    public void validateGymOwner(int gymOwnerId, int isApproved);

}
