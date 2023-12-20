package com.flipkart.client;

import com.flipkart.MainApplicationClient;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.business.*;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.utils.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.MainApplicationClient.scanner;
import static com.flipkart.constant.Constants.*;

public class GymOwnerClient {

    GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    //private List<GymOwner> gymOwnerList = gymOwnerDAO.getGymOwnerList();
    private GymOwnerServiceInterface gymOwnerService = new GymOwnerService();
    private SlotServiceInterface slotService = new SlotService();
    private GymCentreServiceInterface gymCentreService = new GymCentreService();




    public boolean gymOwnerLogin(String userName, String password) {
        int gymOwnerId = gymOwnerService.loginGymOwner(userName,password);
        if (gymOwnerId == -1) {
            new LoginFailedException("Gymowner Login Failed");
            return false;
        } else {
            System.out.println("Successfully logged in");
            gymOwnerClientMainPage(gymOwnerId,userName);
        }
        return true;
    }

    public void register() {
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        int userId = gymOwnerService.registerGymOwner(userName,password,email,panNumber,cardNumber);
        if(userId != -1)
            gymOwnerClientMainPage(userId,userName);
        else
        {
            MainApplicationClient.main(new String[]{});
        }
    }



    public void gymOwnerClientMainPage(int gymOwnerId,String userName) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println(YELLOW_COLOR+"WELCOME "+userName+"!!\nWhat you want to do\nLogin TIME: "+currentTime+RESET_COLOR);
        while(true){
            System.out.println("" +
                    "0. View all my Gym Centres\n" +
                    "1. Sending Gym Owner Approval Request\n" +
                    "2. Add a new Gym Center\n" +
                    "3. Send a Gym Centre Approval Request to Admin\n" +
                    "4. TODO : View Slots\n" +
                    "5. Add Slots to a Gym Centre\n" +
                    "6. Go Back to Previous Menu"
            );
            int choice = scanner.nextInt();
            switch (choice){
                /* Take input from user for all service parameters ( Make the menu ) */

                case 0:
                    List<GymCentre> allGymCentres = gymCentreService.getAllCentresByOwmerId(gymOwnerId);
                    util.printGymCentres(allGymCentres);
                    break;

                case 1:
                    gymOwnerService.requestGymOwnerApproval(gymOwnerId);
                    break;

                case 2:
                    if(gymOwnerService.checkIfGymOwnerIsApprovedById(gymOwnerId))
                    {
                        System.out.println("Enter Gym Centre name: ");
                        String gymCentreName = scanner.next();

                        System.out.println("Enter Gym Centre GSTIN: ");
                        String gstin = scanner.next();

                        System.out.println("Enter Gym Centre city: ");
                        String city = scanner.next();

                        System.out.println("Enter Gym Centre capacity: ");
                        int capacity = scanner.nextInt();

                        System.out.println("Enter price: ");
                        int price = scanner.nextInt();

                        gymCentreService.addCenter(
                                new GymCentre(
                                        gymOwnerId,
                                        gymCentreName,
                                        gstin,
                                        city,
                                        capacity,
                                        price,
                                        0
                                )
                        );
                        break;
                    }
                    else {
                        System.out.println("Please wait for Admin Approval");
                    }
                    break;

                case 3:

                    System.out.println("Enter Gym Centre Id: ");
                    int gymCentreId = scanner.nextInt();

                    gymCentreService.requestGymCentreApproval(gymCentreId);
                    break;
                case 4:
                    System.out.println("Enter Gym Centre Id: ");
                    int gymCentreId1 = scanner.nextInt();
                    List<Slot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(gymCentreId1);
                    if (allSlotsOfThatCentre.size() == 0 )
                    {
                        System.out.println("No Slot Added");
                    }
                    for(Slot slot:allSlotsOfThatCentre)
                    {
                        System.out.print(slot.getSlotId() + " ");
                        System.out.print(slot.getCentreID() + " ");
                        System.out.println(slot.getTime() + " ");

                    }
                    break;
                case 5:
                    if(gymOwnerService.checkIfGymOwnerIsApprovedById(gymOwnerId))
                    {
                        boolean isAdding = true;
                        int centreId = 0;

                        List<Slot> newSlotList = new ArrayList<>();
                            System.out.println("Enter Gym Centre Id: ");
                            centreId = scanner.nextInt();

                            System.out.println("Enter time in 24h format (hh:mm:ss) : ");
                            String time = scanner.next();

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            LocalTime localTime = LocalTime.parse(time, formatter);

                            newSlotList.add(new Slot(
                                    centreId,
                                    localTime
                            ));
                            slotService.addSlotsForGym(centreId, newSlotList);
                    }
                    else {
                        System.out.println("Please Wait For Admin Approval");
                    }

                    break;
                case 6:
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }



}
