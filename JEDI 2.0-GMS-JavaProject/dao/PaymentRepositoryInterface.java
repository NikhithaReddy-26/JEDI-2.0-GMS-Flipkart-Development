package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Payment;

import java.util.List;

public interface PaymentRepositoryInterface {
    void addPayment(int customerId, String upiId, double amount);
}
