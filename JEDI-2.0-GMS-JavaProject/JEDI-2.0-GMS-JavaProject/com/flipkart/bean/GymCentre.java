package com.flipkart.bean;

import lombok.Data;

import java.util.List;
@Data
public class GymCentre {

    //    INSERT INTO FlipFit.GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved)
    private int gymCentreID;
    private int ownerID;
    private String gymCenterName;
    protected String gstin;
    private String city;
    private int capacity;
    private int price;
    private int isApproved;

    public GymCentre() {

    }


    @Override
    public String toString() {
        return "GymCentre{" +
                "gymCentreID='" + gymCentreID + '\'' +
                ", gymCenterName='" + gymCenterName + '\'' +
                ", ownerID='" + ownerID + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    //BAD VOCABULARY
    public GymCentre(int ownerID, String gymCenterName, String gstin, String city, int capacity, int price,int isApproved) {
        this.ownerID = ownerID;
        this.gymCenterName = gymCenterName;
        this.gstin = gstin;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.isApproved = isApproved;
    }

}
