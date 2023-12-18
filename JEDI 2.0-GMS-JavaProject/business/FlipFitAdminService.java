package com.flipkart.gms.business;

import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.beans.Gym;
import com.flipkart.gms.dao.GymRepository;
import com.flipkart.gms.dao.OwnerRepository;

import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminService {
    private OwnerRepository ownerRepository = new OwnerRepository();
    private GymRepository gymRepository = new GymRepository();
    public void viewAllGymOwners() {
        List<FlipFitOwner> ownerList = ownerRepository.getOwners();
        System.out.printf("%-15s\t", "Id");
        System.out.printf("%-15s\t", "Address");
        System.out.printf("%-15s\t", "Email");
        System.out.printf("%-15s\t", "GST Number");
        System.out.printf("%-15s\t", "Name");
        System.out.printf("%-15s\t", "Phone");
        System.out.printf("%-15s\t", "IsApproved");
        System.out.println();
        for(FlipFitOwner gymOwner: ownerList) {
            System.out.printf("%-15s\t", gymOwner.getId());
            System.out.printf("%-15s\t", gymOwner.getAddress());
            System.out.printf("%-15s\t", gymOwner.getEmail());
            System.out.printf("%-15s\t", gymOwner.getGstNumber());
            System.out.printf("%-15s\t", gymOwner.getName());
            System.out.printf("%-15s\t", gymOwner.getPhone());
            if(gymOwner.isApproved())
            {
				System.out.printf("%-8s\t", "Yes");
            }
            else
            {
				System.out.printf("%-8s\t", "No");
            }
            System.out.println("");
        }
    }

    public void viewAllGymCenters() {
        ArrayList<Gym> gymList = gymRepository.getAllGyms();
        System.out.printf("%-15s\t", "Id");
        System.out.printf("%-15s\t", "Name");
        System.out.printf("%-15s\t", "Location");
        System.out.printf("%-15s\t", "No of Seats");
        System.out.printf("%-15s\t", "GymOwnerEmail");
        System.out.printf("%-15s\t", "IsApproved");
        System.out.println();
        for(Gym gymCenter: gymList) {
            System.out.printf("%-15s\t", gymCenter.getId());
            System.out.printf("%-15s\t", gymCenter.getName());
            System.out.printf("%-15s\t", gymCenter.getLocation());
            System.out.printf("%-15s\t", gymCenter.getNoOfSeats());
            System.out.printf("%-15s\t", gymCenter.getGymOwnerEmail());

            if(gymCenter.isApproved())
            {
				System.out.printf("%-8s\t", "Yes");
            }
            else
            {
				System.out.printf("%-8s\t", "No");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------");
    }

    public void viewPendingGymOwnerRequests() {
        List<FlipFitOwner> flipFitOwnerList = ownerRepository.getOwners();
        System.out.printf("%-15s\t", "Id");
        System.out.printf("%-15s\t", "Address");
        System.out.printf("%-15s\t", "Email");
        System.out.printf("%-15s\t", "GST Number");
        System.out.printf("%-15s\t", "Name");
        System.out.printf("%-15s\t", "Phone");
        System.out.println();
        for(FlipFitOwner gymOwner: flipFitOwnerList) {
            if(!gymOwner.isApproved())
            {
                System.out.printf("%-15s\t", gymOwner.getId());
                System.out.printf("%-15s\t", gymOwner.getAddress());
                System.out.printf("%-15s\t", gymOwner.getEmail());
                System.out.printf("%-15s\t", gymOwner.getGstNumber());
                System.out.printf("%-15s\t", gymOwner.getName());
                System.out.printf("%-15s\t", gymOwner.getPhone());
            }
            System.out.println("");
        }
    }

    public void viewPendingGymRequests() {
        List<Gym> gymList = gymRepository.getAllGyms();
        System.out.printf("%-15s\t", "Id");
        System.out.printf("%-15s\t", "Name");
        System.out.printf("%-15s\t", "Location");
        System.out.printf("%-15s\t", "No of Seats");
        System.out.printf("%-15s\t", "GymOwnerEmail");
        System.out.println();
        for(Gym gymCenter: gymList) {

            if(!gymCenter.isApproved())
            {
                System.out.printf("%-15s\t", gymCenter.getId());
                System.out.printf("%-15s\t", gymCenter.getName());
                System.out.printf("%-15s\t", gymCenter.getLocation());
                System.out.printf("%-15s\t", gymCenter.getNoOfSeats());
                System.out.printf("%-15s\t", gymCenter.getGymOwnerEmail());
            }
            System.out.println("");
        }
    }

    public void approveGymRequest(int gymId)
    {
        Gym gym = gymRepository.getGymById(gymId);
        if(gym!=null)
        {
            gym.setApproved(true);
            System.out.println("Gym is successfully approved of ID "+gymId);
        }
        else {
            System.out.println("Invalid Gym Id "+gymId);
        }
    }

    public void approveGymOwnerRequest(int gymOwnerId)
    {
        FlipFitOwner flipFitOwner = ownerRepository.getGymOwnerById(gymOwnerId);
        if(flipFitOwner!=null)
        {
            flipFitOwner.setApproved(true);
            System.out.println("Flip Fit Gym Owner successfully Approved ID: "+gymOwnerId);
        }
        else {
            System.out.println("Invalid Gym Owner Id "+gymOwnerId);
        }
    }

}
