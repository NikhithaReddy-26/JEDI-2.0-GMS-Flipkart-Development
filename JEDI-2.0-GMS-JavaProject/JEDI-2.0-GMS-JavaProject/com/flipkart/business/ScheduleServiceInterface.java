package com.flipkart.business;

import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;

import java.sql.Date;
import java.util.List;

public interface ScheduleServiceInterface {
    void createSchedule(Date date, int slotId);
    Schedule getScheduleByDateAndSlotId(int SlotId, Date date);
    boolean modifySchedule(int scheduleId,int action);
    List<Schedule> checkAvailability(int centreID, Date date);
    List<Slot> getAllAvailableSlotsByDate(int centreID, Date date);
    Schedule getOrCreateSchedule(int slotId, Date date);
}
