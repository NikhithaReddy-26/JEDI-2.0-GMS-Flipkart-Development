package com.flipkart.bean;

import lombok.Data;

@Data
public class Booking {


    private int bookingID;
    private int userID;
    private int scheduleID;

    public Booking(int userID, int scheduleID) {
        this.userID = userID;
        this.scheduleID = scheduleID;
    }


}
