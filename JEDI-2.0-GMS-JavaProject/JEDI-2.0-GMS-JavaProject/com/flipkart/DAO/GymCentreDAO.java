package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.constant.SQLConstants.FETCH_GYM_CENTRE_BY_ID;

public class GymCentreDAO implements GymCentreInterfaceDAO {
    private Connection conn = null;
    private PreparedStatement statement = null;

    public GymCentreDAO() {
    }

    // api call to retrieve all gym centres and status
    public List<GymCentre> getAllCentresByOwnerId(int gymOwnerId)  {

        List<GymCentre> allGymCentres = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_OWNER_ID);
            statement.setInt(1, gymOwnerId);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                GymCentre gymCentre = new GymCentre(
                        rs.getInt("ownerId"),
                        rs.getString("gymCenterName"),
                        rs.getString("gstin"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price"),
                        rs.getInt("isApproved")
                );
                gymCentre.setGymCentreID(rs.getInt("gymCentreID"));
                allGymCentres.add(gymCentre);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return allGymCentres;
    }



    public GymCentre getGymCentreByCentreId(int gymCentreId){
        GymCentre gymCentre = new GymCentre();
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(FETCH_GYM_CENTRE_BY_ID);
            stmt.setInt(1, gymCentreId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            gymCentre.setGymCentreID(rs.getInt("gymCentreID"));
            gymCentre.setOwnerID(rs.getInt("ownerID"));
            gymCentre.setGymCenterName(rs.getString("gymCenterName"));
            gymCentre.setGstin(rs.getString("gstin"));
            gymCentre.setCity(rs.getString("city"));
            gymCentre.setCapacity(rs.getInt("capacity"));
            gymCentre.setPrice(rs.getInt("price"));
            gymCentre.setIsApproved(rs.getInt("isApproved"));
            stmt.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }

        return gymCentre;

    }

    public void addGymCentre(GymCentre centre) {
        // call to db api
        try {
            conn = DBConnection.connect();
            System.out.println("Adding gym centre....");

            //    INSERT INTO FlipFit.GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved)
            statement = conn.prepareStatement(SQLConstants.ADD_GYM_CENTRE_QUERY);
            statement.setInt(1,centre.getOwnerID());
            statement.setString(2, centre.getGymCenterName());
            statement.setString(3,centre.getGstin());
            statement.setString(4, centre.getCity());
            statement.setInt(5, centre.getCapacity());
            statement.setInt(6, centre.getPrice());
            statement.setInt(7, 0);

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<GymCentre> getPendingGymCentreList() {
        List<GymCentre> pendingList = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gym centres..");

            statement = conn.prepareStatement(SQLConstants.FETCH_ALL_PENDING_GYM_CENTRES_QUERY);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                GymCentre gymCentre = new GymCentre(
                        rs.getInt("ownerId"),
                        rs.getString("gymCenterName"),
                        rs.getString("gstin"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price"),
                        rs.getInt("isApproved")
                );
                gymCentre.setGymCentreID(rs.getInt("gymCentreID"));
                pendingList.add(gymCentre);
            }
            //conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pendingList;
    }

    public void validateGymCentre(int gymCentreId, int isApproved) {
//        System.out.println("IN VALIDATE GYM CENTRE");
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres..");

            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1, isApproved);
            statement.setInt(2, gymCentreId);
            statement.executeUpdate();
//            System.out.println("The gym centre has been approved!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
//        for(GymCentre gymCentre : gymCentreList) {
//            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
//                gymCentre.setApproved(isApproved);
//            }
//        }
//        for(GymCentre gymCentre : pendingGymCentreList) {
//            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
//                pendingGymCentreList.remove(gymCentre);
//            }
//        }
    }

    public void sendCentreApprovalRequest(int gymCentreId){
        try {
            conn = DBConnection.connect();
            System.out.println("Sending gym centre approval request..");
            // SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update GymCentre Set isApproved=? WHERE centreId=?";
            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1,2);
            statement.setInt(2, gymCentreId);
            statement.executeUpdate();

        } catch (SQLException se) { se.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public List<GymCentre> getGymCentreListByCity(String city) {
        List<GymCentre> allCentreByCity = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres by City..");
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_CITY);
            statement.setString(1, city);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                GymCentre gymCentre = new GymCentre(
                        rs.getInt("ownerID"),
                        rs.getString("gymCenterName"),
                        rs.getString("gstin"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price"),
                        rs.getInt("isApproved")

                );

                gymCentre.setGymCentreID(rs.getInt("gymCentreID"));
                if(gymCentre.getIsApproved() == 1)
                    allCentreByCity.add(gymCentre);
            }
            //System.out.println("The gym centre has been approved!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
//        for(GymCentre gymCentre: gymCentreList){
//            if(gymCentre.getCity().equals(city)){
//                allCentreByCity.add(gymCentre);
//            }
//        }
        return allCentreByCity;
    }
}
