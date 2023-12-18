package com.flipkart.gms.business;

public interface FlipFitAdminServiceInterface {
        void viewAllGymOwners();
        void viewAllGymCenters();
        void viewPendingGymOwnerRequests();
        void viewPendingGymRequests();
        void approveGymRequest(int gymId);
        void approveGymOwnerRequest(int gymOwnerId);
    }


