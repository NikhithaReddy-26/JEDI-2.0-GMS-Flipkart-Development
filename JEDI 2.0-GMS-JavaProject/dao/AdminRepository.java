package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Admin;
import com.flipkart.gms.beans.FlipFitCustomer;

import java.util.ArrayList;
import java.util.List;

import static com.flipkart.gms.dao.CustomerRepository.customers;

public class AdminRepository {
    List<Admin> adminList = new ArrayList<>();
    public void addAdmin()
    {
        Admin admin = new Admin();
        admin.setName("Nikhitha");
        admin.setPassword("password");
        adminList.add(admin);
    }
    public ArrayList<Admin> getAdminList()
    {
        addAdmin();
        return (ArrayList<Admin>) adminList;
    }
}
