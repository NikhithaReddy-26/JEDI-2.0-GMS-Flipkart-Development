package com.flipkart.DAO;

import com.flipkart.bean.Slot;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SlotDAO implements SlotInterfaceDAO {
    public SlotDAO(){
    }

    public List<Slot> getSlotList() {
        List<Slot> slotList = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_ALL_SLOTS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int slotId = rs.getInt("slotId");
                int centreId = rs.getInt("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();
                Slot slot = new Slot(centreId,time);
                slot.setSlotId(slotId);
                slotList.add(slot);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }

    public List<Slot> getSlotByCentreId(int gymCentreId){
        List<Slot> slotList = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_CENTRE);
            ps.setInt(1,gymCentreId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int slotId = rs.getInt("slotId");
                int centreId = rs.getInt("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();
                Slot slot = new Slot(centreId,time);
                slot.setSlotId(slotId);
                slotList.add(slot);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }

    public void addSlot(Slot slot){
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_SLOT);
            ps.setInt(1, slot.getCentreID());
            ps.setTime(2, java.sql.Time.valueOf(slot.getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Slot getSlotById(int slotID) {
        Slot slot = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_ID);
            ps.setInt(1,slotID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int centreId = rs.getInt("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();
                slot = new Slot(centreId, time);
                slot.setSlotId(slotID);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slot;
    }

    public Slot getSlotByIdandCentreId(int slotID, int centreID) {
        Slot slot = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_ID_AND_CENTRE_ID);
            ps.setInt(1,slotID);
            ps.setInt(2,centreID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LocalTime time = rs.getTime("time").toLocalTime();
                slot = new Slot(centreID, time);
                slot.setSlotId(slotID);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slot;
    }
}
