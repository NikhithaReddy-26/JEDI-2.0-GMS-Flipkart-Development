package com.flipkart.bean;

import java.sql.Date;
import java.util.UUID;

public class Schedule {

    private int scheduleID;
    private Date date;
    private int slotID;
    private int availability;

    public Schedule(Date date, int slotID, int availability) {
        this.date = date;
        this.slotID = slotID;
        this.availability = availability;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }


}
