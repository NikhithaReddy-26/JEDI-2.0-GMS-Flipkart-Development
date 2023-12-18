package com.flipkart.gms.business;

import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.beans.Gym;
import com.flipkart.gms.dao.GymRepository;
import com.flipkart.gms.dao.GymRepositoryInterface;
import com.flipkart.gms.dao.OwnerRepository;
import com.flipkart.gms.dao.OwnerRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the administrative services for managing FlipFit gym owners and gym centers.
 */
public class FlipFitAdminService implements FlipFitAdminServiceInterface {

    private final OwnerRepositoryInterface ownerRepository = new OwnerRepository();
    private final GymRepositoryInterface gymRepository = new GymRepository();

    /**
     * Retrieves and displays details of all gym owners.
     */
    public void viewAllGymOwners() {
        List<FlipFitOwner> ownerList = ownerRepository.getOwners();

        // Display headers
        displayOwnerHeaders();

        // Display details of all gym owners
        for (FlipFitOwner gymOwner : ownerList) {
            displayOwnerDetails(gymOwner);
        }
    }

    // Helper method to display owner details headers
    private void displayOwnerHeaders() {
        System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t\n",
                "Id", "Address", "Email", "GST Number", "Name", "Phone", "IsApproved");
    }

    // Helper method to display individual owner details
    private void displayOwnerDetails(FlipFitOwner gymOwner) {
        System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-8s\t\n",
                gymOwner.getId(), gymOwner.getAddress(), gymOwner.getEmail(),
                gymOwner.getGstNumber(), gymOwner.getName(), gymOwner.getPhone(),
                gymOwner.isApproved() ? "Yes" : "No");
    }

    /**
     * Retrieves and displays details of all gym centers.
     */
    public void viewAllGymCenters() {
        ArrayList<Gym> gymList = gymRepository.getAllGyms();

        // Display headers
        displayGymHeaders();

        // Display details of all gym centers
        for (Gym gymCenter : gymList) {
            displayGymDetails(gymCenter);
        }

        System.out.println("-------------------------------------");
    }

    // Helper method to display gym details headers
    private void displayGymHeaders() {
        System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-8s\t\n",
                "Id", "Name", "Location", "No of Seats", "GymOwnerId", "IsApproved");
    }

    // Helper method to display individual gym details
    private void displayGymDetails(Gym gymCenter) {
        System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-8s\t\n",
                gymCenter.getId(), gymCenter.getName(), gymCenter.getLocation(),
                gymCenter.getNoOfSeats(), gymCenter.getGymOwnerId(),
                gymCenter.isApproved() ? "Yes" : "No");
    }

    /**
     * Retrieves and displays pending gym owner requests yet to be approved.
     */
    public void viewPendingGymOwnerRequests() {
        List<FlipFitOwner> flipFitOwnerList = ownerRepository.getOwners();

        // Display headers
        displayOwnerHeaders();

        // Display pending gym owner requests
        for (FlipFitOwner gymOwner : flipFitOwnerList) {
            if (!gymOwner.isApproved()) {
                displayOwnerDetails(gymOwner);
            }
        }
    }

    /**
     * Retrieves and displays pending gym requests yet to be approved.
     */
    public void viewPendingGymRequests() {
        List<Gym> gymList = gymRepository.getAllGyms();

        // Display headers
        displayGymHeaders();

        // Display pending gym requests
        for (Gym gymCenter : gymList) {
            if (!gymCenter.isApproved()) {
                displayGymDetails(gymCenter);
            }
        }
    }

    /**
     * Approves a gym request by its ID.
     *
     * @param gymId The ID of the gym to be approved.
     */
    public void approveGymRequest(int gymId) {
        Gym gym = gymRepository.getGymById(gymId);
        if (gym != null) {
            gym.setApproved(true);
            System.out.println("Gym is successfully approved of ID " + gymId);
        } else {
            System.out.println("Invalid Gym Id " + gymId);
        }
    }

    /**
     * Approves a gym owner request by their ID.
     *
     * @param gymOwnerId The ID of the gym owner to be approved.
     */
    public void approveGymOwnerRequest(int gymOwnerId) {
        FlipFitOwner flipFitOwner = ownerRepository.getGymOwnerById(gymOwnerId);
        if (flipFitOwner != null) {
            flipFitOwner.setApproved(true);
            System.out.println("Flip Fit Gym Owner successfully Approved ID: " + gymOwnerId);
        } else {
            System.out.println("Invalid Gym Owner Id " + gymOwnerId);
        }
    }
}
