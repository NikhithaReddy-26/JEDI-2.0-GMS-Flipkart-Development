package com.flipkart.gms.client;

import com.flipkart.gms.GmsApplication;
import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.beans.Gym;
import com.flipkart.gms.beans.Slot;
import com.flipkart.gms.business.FlipFitOwnerService;

import java.util.List;
import java.util.Scanner;

public class GymOwnerClient {
    private Scanner sc;
    private FlipFitOwnerService flipFitOwnerService = new FlipFitOwnerService();
    public void ownerMenu(int ownerId, boolean approved)
    {
        if(!approved)
        {
            System.out.println("You are not a Authorized Gym Owner");
        }
        else
        {
            sc = new Scanner(System.in);
            while (true)
            {
                System.out.println("1. Add Gyms");
                System.out.println("2. View All Gyms");
                System.out.println("3. Add Slots in a Gym");
                System.out.println("4. View All Slots of a Gym");
                System.out.println("5. View Own Details");
                System.out.println("6. Exit");
                System.out.println("------------------------------");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        registerGym(ownerId, sc);
                        break;
                    case 2:
                        getAllGymDetails(ownerId);
                        break;
                    case 3:
                        addSlots(sc, ownerId);
                        break;
                    case 4:
                        viewAllSlots(ownerId);
                        break;
                    case 5:
                        getGymOwnerDetails(ownerId);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Incorrect Choice");
                }
            }
        }
    }

    private void getGymOwnerDetails(int ownerId)
    {
        FlipFitOwner gymOwner = flipFitOwnerService.getOwnerById(ownerId);
        System.out.printf("%-15s\t", "Id");
        System.out.printf("%-15s\t", "Name");
        System.out.printf("%-15s\t", "Email");
        System.out.printf("%-15s\t", "Address");
        System.out.printf("%-15s\t", "GstNumber");
        System.out.printf("%-15s\t", "Phone");
        System.out.println();
        System.out.printf("%-15s\t", gymOwner.getId());
        System.out.printf("%-15s\t", gymOwner.getName());
        System.out.printf("%-15s\t", gymOwner.getEmail());
        System.out.printf("%-15s\t", gymOwner.getAddress());
        System.out.printf("%-15s\t", gymOwner.getGstNumber());
        System.out.printf("%-15s\t", gymOwner.getPhone());
        if(gymOwner.isApproved())
        {
			System.out.printf("%-15s\t", "Yes");
        }
        else
        {
			System.out.printf("%-15s\t", "No");
        }
        System.out.println("");
    }

    private void viewAllSlots(int ownerId)
    {
        System.out.println("Enter the gymCenter id for which you want to see all slots: ");
        int gymId = sc.nextInt();
        boolean isGymApproved = flipFitOwnerService.checkGymApproval(gymId,ownerId);
        if (isGymApproved)
        {
            viewSlotsByGymId(gymId);
        }
        else
        {
            System.out.println("Gym is not approved or invalid Gym Id");
        }
    }

    private void viewSlotsByGymId(int gymId)
    {
        System.out.println("Listing all existing slots: ");
        List<Slot> allSlots = flipFitOwnerService.viewAllSlotsByGymId(gymId);
        System.out.printf("%-15s\t", "Id");
        System.out.printf("%-15s\t", "Time");
        System.out.println();
        for(Slot slot : allSlots) {
            System.out.printf("%-15s\t", slot.getId());
            System.out.printf("%-15s\t", slot.getTime());
            System.out.println("");
        }
        System.out.println("-------------------------------------");
    }

    private void addSlots(Scanner sc, int ownerId)
    {
        getAllGymDetails(ownerId);
        System.out.println("Enter the gymCenter id for which you want to add slots: ");
        int gymId = sc.nextInt();
        boolean isGymApproved = flipFitOwnerService.checkGymApproval(gymId,ownerId);
        if (isGymApproved)
        {
            viewSlotsByGymId(gymId);
            System.out.println("Add slot timing: ");
            String time = sc.next();
            flipFitOwnerService.addGym(gymId,time);
            System.out.println("Slot Successfully Added");
        }
        else
        {
            System.out.println("Gym is not approved or invalid Gym Id");
        }
    }

    private void getAllGymDetails(int ownerId)
    {
        List<Gym> gymList = flipFitOwnerService.getAllGymByOwnerId(ownerId);
        System.out.printf("%-15s\t", "Id");
        System.out.printf("%-15s\t", "Name");
        System.out.printf("%-15s\t", "Location");
        System.out.printf("%-15s\t", "No of Seats");
        System.out.println();
        for(Gym gym : gymList) {
            System.out.printf("%-15s\t", gym.getId());
            System.out.printf("%-15s\t", gym.getName());
            System.out.printf("%-15s\t", gym.getLocation());
            System.out.printf("%-15s\t", gym.getNoOfSeats());

            if(gym.isApproved())
            {
				System.out.printf("%-15s\t", "Yes");
            }
            else
            {
				System.out.printf("%-15s\t", "No");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------");
    }

    private void registerGym(int ownerId, Scanner sc)
    {
        System.out.println("Add gym Details: ");
        System.out.print("Enter gym Name: ");
        String gymName = sc.next();
        System.out.print("Enter gym location: ");
        String gymLocation = sc.next();
        System.out.println("Enter the number of seats per slot: ");
        int seats = sc.nextInt();
        System.out.println("Enter Cost of per seat: ");
        double amount = sc.nextDouble();
        flipFitOwnerService.registerGym(ownerId,gymName,gymLocation,seats,amount);

    }
}
