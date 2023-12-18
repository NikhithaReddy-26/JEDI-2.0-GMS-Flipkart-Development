package com.flipkart.gms.dao;

import com.flipkart.gms.beans.FlipFitCustomer;

import java.util.List;

public interface CustomerRepositoryInterface {
    List<FlipFitCustomer> getCustomers();

    void add(FlipFitCustomer customer);
}
