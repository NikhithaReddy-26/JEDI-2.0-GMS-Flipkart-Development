package com.flipkart.bean;

import java.time.LocalTime;

public class Slot {
    private int slotId;
    private int centreID;
    private LocalTime time;

    public Slot(int centreID, LocalTime time) {
        this.centreID = centreID;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId='" + slotId + '\'' +
                ", time=" + time +
                '}';
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getCentreID() {
        return centreID;
    }

    public void setCentreID(int centreID) {
        this.centreID = centreID;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
