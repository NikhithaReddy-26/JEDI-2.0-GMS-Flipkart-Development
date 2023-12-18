package com.flipkart.gms.client;

import com.flipkart.gms.GmsApplication;

public class GymOwnerClient {
    public void ownerMenu(int id, boolean approved)
    {
        if(!approved)
        {
            System.out.println("You are not a Authorized Gym Owner");
            GmsApplication.mainMenu();
        }
        else
        {

        }
    }
}
