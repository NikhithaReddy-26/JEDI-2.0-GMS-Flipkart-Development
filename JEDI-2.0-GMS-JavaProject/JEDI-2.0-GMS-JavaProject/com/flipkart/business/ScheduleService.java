package com.flipkart.business;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.flipkart.DAO.ScheduleDAO;
import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;

public class ScheduleService implements ScheduleServiceInterface {

    private GymCentreService gymCentreService = new GymCentreService();
    private SlotService slotService = new SlotService();
    private ScheduleDAO scheduleDAO = new ScheduleDAO();

    public void createSchedule(Date date, int slotId){
        int centreID = slotService.getSlotByID(slotId).getCentreID();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        Schedule schedule = new Schedule( date, slotId, availability);
        scheduleDAO.addSchedule(schedule);
    }

    public Schedule getScheduleByDateAndSlotId(int SlotId, Date date){
        //returns whether current schedule exists or not
        List<Schedule> scheduleList = scheduleDAO.getAllScheduleByDate(date);
        for(Schedule schedule: scheduleList){
            if(schedule.getSlotID() == SlotId)
                return schedule;
        }

        //Schedule doesn't exist, return null
        return null;
    }

    public boolean modifySchedule(int scheduleId,int action){
        // increment or decrement availability based on action
        // 1 for increasing availability, -1 for decreasing
        return scheduleDAO.modifySchedule(scheduleId, action);
    }

    public List<Schedule> checkAvailability(int centreID, Date date){
        List<Slot> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);
        List<Schedule> allAvailableSchedules = new ArrayList<>();
        for(Slot slot : allSlotsForGym){
            int slotId = slot.getSlotId();
            Schedule schedule = getOrCreateSchedule(slotId, date);
            if(schedule.getAvailability() > 0)
                allAvailableSchedules.add(schedule);
        }

        return allAvailableSchedules;
    }

    public List<Slot> getAllAvailableSlotsByDate(int centreID, Date date) {
        List<Slot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
        List<Slot> response = slotService.getAllSlotsByCentre(centreID);
        for(Slot slot: allSlotsOfThatCentre){
            for(Schedule schedule: scheduleDAO.getAllScheduleByDate(date)){
                if (slotService.getSlotByID(schedule.getSlotID()).getCentreID() == centreID){
                    if(schedule.getAvailability() <= 0){
                        response.remove(slot);
                    }
                }
            }
        }
        return response;
    }

    public Schedule getSchedule(int scheduleID){
        return scheduleDAO.getSchedule(scheduleID);
    }

    public Schedule getOrCreateSchedule(int slotId, Date date) {
        Schedule schedule = getScheduleByDateAndSlotId(slotId, date);
        if( schedule == null ){
            createSchedule(date,slotId);
            return getOrCreateSchedule(slotId,date);
        }
        return schedule;

    }
}
