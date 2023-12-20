package com.flipkart.constant;

public class SQLConstants {

    // ------------------------ GYM OWNER ------------------------
    // ------------------------ GYM OWNER ------------------------
    public static final String FETCH_ALL_GYM_OWNERS_QUERY = "SELECT * FROM FlipFit.FlipFitGymOwner";
    public static final String FETCH_ALL_PENDING_GYM_OWNERS_QUERY = "SELECT * FROM FlipFit.FlipFitGymOwner WHERE isApproved = 2";
    public static final String SEND_GYM_OWNER_APPROVAL_REQ_QUERY = "UPDATE FlipFit.FlipFitGymOwner SET isApproved = 2 WHERE userID = ?;";

    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO FlipFit.GymCentre ( ownerID, gymCenterName, gstin, city, capacity, price, isApproved) VALUES (?, ?, ?, ?, ?, ?, ?)";

    // ------------ GYM OWNER ------------
    public static final String REGISTER_GYM_OWNER = "INSERT INTO FlipFitGymOwner (userName, email, password, panNumber, cardDetails, isApproved) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String LOGIN_GYM_OWNER = "SELECT * FROM FlipFitGymOwner WHERE userName=? AND password=?";
    public static final String SQL_APPROVE_GYM_OWNER_BY_ID_QUERY = "UPDATE FlipFitGymOwner SET isApproved=? WHERE userID=?";

    // ------------------------ GYM CENTRE ------------------------
    public static final String FETCH_GYM_CENTRES_BY_OWNER_ID = "SELECT * FROM FlipFit.GymCentre WHERE ownerID = ?";
    public static final String FETCH_ALL_PENDING_GYM_CENTRES_QUERY = "SELECT * FROM FlipFit.GymCentre WHERE isApproved = 2";
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY = "UPDATE FlipFit.GymCentre SET isApproved=? WHERE gymCentreID=?";
    public static final String FETCH_GYM_CENTRES_BY_CITY = "SELECT * FROM FlipFit.GymCentre WHERE city = ?";
    public static final String FETCH_GYM_CENTRE_BY_ID = "SELECT * FROM FlipFit.GymCentre WHERE gymCentreID = ?";

    // ------------------------ CUSTOMER ------------------------
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM FlipFit.Customer WHERE userName = ? AND password = ?";
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO FlipFit.Customer (userName, password, email, customerPhone, cardDetails) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_CUSTOMER_BY_ID = "SELECT * FROM FlipFit.Customer WHERE userName = ?";

    // ----------- Booking -----------
    public static final String GET_BOOKING_BY_CUSTOMER_ID = "SELECT * FROM FlipFit.Booking WHERE userID = ?";
    public static final String CANCEL_BOOKING_BY_ID = "DELETE FROM FlipFit.Booking WHERE bookingID = ?";
    public static final String ADD_BOOKING = "INSERT INTO FlipFit.Booking ( userID, scheduleID) VALUES (?, ?)";

    // ------------- Schedule -------------
    public static final String ADD_SCHEDULE = "INSERT INTO FlipFit.Schedule (date, slotID, availability) VALUES ( ?, ?, ?)";
    public static final String GET_SCHEDULES_BY_DATE = "SELECT * FROM FlipFit.Schedule WHERE date = ?";
    public static final String GET_SCHEDULE_BY_ID = "SELECT * FROM FlipFit.Schedule WHERE scheduleID = ?";
    public static final String MODIFY_SCHEDULE_AVAILABILITY = "UPDATE FlipFit.Schedule SET availability = ? WHERE scheduleID = ?";

    // ---------------- Slot ----------------
    public static final String FETCH_ALL_SLOTS = "SELECT * FROM FlipFit.Slot";
    public static final String FETCH_SLOT_BY_CENTRE = "SELECT * FROM FlipFit.Slot WHERE centreID = ?";
    public static final String ADD_SLOT = "INSERT INTO FlipFit.Slot (centreID, time) VALUES (?, ?)";
    public static final String FETCH_SLOT_BY_ID = "SELECT * FROM FlipFit.Slot WHERE slotID = ?";
    public static final String FETCH_SLOT_BY_ID_AND_CENTRE_ID = "SELECT * FROM FlipFit.Slot WHERE slotID = ? AND centreID = ?";

    public static final String GET_BOOKING_BY_BOOKING_ID = "SELECT * FROM FlipFit.Booking WHERE bookingID = ?";

    public static final String GET_USERPLAN_BY_CUSTOMER_ID = "SELECT * FROM FlipFit.Slot JOIN FlipFit.Schedule WHERE FlipFit.Slot.slotID = FlipFit.Schedule.slotID AND FlipFit.Schedule.scheduleID = ?";

    public static final String CHECK_OWNER_APPROVAL = "SELECT isApproved FROM FlipFit.FlipFitGymOwner WHERE userId = ?";
}
