package com.flipkart.gms.client;

import com.flipkart.gms.GmsApplication;
import com.flipkart.gms.beans.Bookings;
import com.flipkart.gms.beans.Gym;
import com.flipkart.gms.beans.Slot;
import com.flipkart.gms.business.FlipFitCustomerService;
import com.flipkart.gms.business.FlipFitCustomerServiceInterface;
import com.flipkart.gms.business.FlipFitOwnerService;
import com.flipkart.gms.business.FlipFitOwnerServiceInterface;

import java.util.List;
import java.util.Scanner;

public class CustomerClient {

    private final FlipFitCustomerServiceInterface flipFitCustomerService = new FlipFitCustomerService() {
    };
    private final FlipFitOwnerServiceInterface flipFitOwnerService = new FlipFitOwnerService();
    public void customerMenu(int customerId)
    {
        while(true) {
            System.out.println("------------------------------ \n 1. View catalog \n 2. Book slot \n 3. View all booked Slots \n 4. Cancel Booked slot \n 5. Exit \n ------------------------------ \n Enter your choice: " );
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewCatalog();
                    break;
                case 2:
                    bookSlot(customerId,sc);
                    break;
                case 3:
                    viewAllBookedSlots(customerId);
                    break;
                case 4:
                    cancelBookedSlot(sc);
                    break;
                case 5:
                    GmsApplication.mainMenu();
                    return;
                default:
                    System.out.println("Incorrect choice");
            }
        }
    }

    private void cancelBookedSlot(Scanner sc)
    {
        System.out.println("Enter the Booking Id :");
        int bookingId = sc.nextInt();
        System.out.println(flipFitCustomerService.cancelBookingById(bookingId));
    }

    private void viewAllBookedSlots(int customerId)
    {
        List<Bookings> bookedSlots= flipFitCustomerService.viewAllBookings(customerId);
        System.out.printf("%-15s\t","Id");
        System.out.printf("%-15s\t","Slot Id");
        System.out.printf("%-15s\t","GymCenterID");
        System.out.printf("%-15s\t","Date");
        System.out.println();
        for(Bookings bs: bookedSlots) {
            System.out.printf("%-15s\t", bs.getId());
            System.out.printf("%-15s\t", bs.getSlotId());
            System.out.printf("%-15s\t", bs.getGymCenterId());
            System.out.printf("%-15s\t", bs.getDate());
            System.out.println();
        }
    }

    private void viewCatalog() {
        List<Gym> allApprovedGyms = flipFitCustomerService.getAllApprovedGym();
        System.out.printf("%-15s\t","Id");
        System.out.printf("%-15s\t","Name");
        System.out.printf("%-15s\t","Location");
        System.out.printf("%-15s\t","No of Seats");
        System.out.println();
        for(Gym gym: allApprovedGyms) {
            System.out.printf("%-15s\t", gym.getId());
            System.out.printf("%-15s\t",gym.getName());
            System.out.printf("%-15s\t", gym.getLocation());
            System.out.printf("%-15s\t", gym.getNoOfSeats());
            System.out.println();
            System.out.println("Listing all Slots in "+gym.getName());
            System.out.println("-------------------------------------");
            List<Slot> allAvailableSlots = flipFitOwnerService.viewAllSlotsByGymId(gym.getId());
            if(allAvailableSlots.size()>0)
            {
                System.out.printf("%-15s\t","Id");
                System.out.printf("%-15s\t","Time");
                System.out.println();
                for(Slot slot: allAvailableSlots) {
                    System.out.printf("%-15s\t", slot.getId());
                    System.out.printf("%-15s\t", slot.getTime());
                    System.out.println();
                }
                System.out.println("-----------------------------");
            }
        }
        System.out.println("-----------------------------");

    }

    private void bookSlot(int customerId,Scanner sc)
    {
        System.out.println("Enter Gym ID: ");
        int gymCentreId = sc.nextInt();
        System.out.println("Enter Slot ID: ");
        int slotId = sc.nextInt();
        System.out.println("Enter the date in DD-MM-YYYY format: ");
        String date = sc.next();
        System.out.println(flipFitCustomerService.bookSlot(customerId,gymCentreId,slotId,date,sc));
    }
}
