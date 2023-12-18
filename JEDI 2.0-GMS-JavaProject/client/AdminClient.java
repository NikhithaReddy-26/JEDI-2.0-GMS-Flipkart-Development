package com.flipkart.gms.client;

import com.flipkart.gms.GmsApplication;
import com.flipkart.gms.business.FlipFitAdminService;

import java.util.Scanner;

public class AdminClient {
    FlipFitAdminService flipFitAdminService = new FlipFitAdminService();
    public void adminPage()
    {
        while(true) {
            System.out.println("------------------------------" );
            System.out.println(" 1. View All Gym Owners \n 2. View All Gyms \n 3. View Pending Gym Owner Requests \n 4. View Pending Gym Requests \n 5. Approve Gym Request \n 6. Approve Gym Owner Request \n 7. Exit \n ------------------------------ \n Enter your choice: ");


            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    flipFitAdminService.viewAllGymOwners();
                    break;
                case 2:
                    flipFitAdminService.viewAllGymCenters();
                    break;
                case 3:
                    flipFitAdminService.viewPendingGymOwnerRequests();
                    break;
                case 4:
                    flipFitAdminService.viewPendingGymRequests();
                    break;
                case 5:
                    System.out.println("Enter the gym Id: ");
                    int gymId = sc.nextInt();
                    flipFitAdminService.approveGymRequest(gymId);
                    break;
                case 6:
                    System.out.println("Enter the gym owner Id: ");
                    int gymOwnerId = sc.nextInt();
                    flipFitAdminService.approveGymOwnerRequest(gymOwnerId);
                    break;
                case 7:
                    GmsApplication.mainMenu();
                    return;

                default:
				    System.out.println("Wrong choice");
            }
        }
    }
}
