package com.flipkart.gms.dao;

import com.flipkart.gms.beans.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements PaymentRepositoryInterface {
    List<Payment> paymentList = new ArrayList<>();
    public void addPayment(int customerId, String upiId, double amount)
    {
        Payment payment = new Payment(customerId,upiId,amount);
        paymentList.add(payment);
    }
}
