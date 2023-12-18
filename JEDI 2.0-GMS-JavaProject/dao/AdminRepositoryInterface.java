package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Admin;

import java.util.ArrayList;

public interface AdminRepositoryInterface {
    void addAdmin();

    ArrayList<Admin> getAdminList();
}
