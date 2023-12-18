package com.flipkart.gms.client;

import com.flipkart.gms.dao.PaymentRepository;

import java.util.Scanner;

public class PaymentClient {
    PaymentRepository paymentRepository = new PaymentRepository();
    public void makePayment(int customerId, double amount, Scanner sc)
    {
        System.out.println("Enter UPI Id for payment of amount "+ amount + " :");
        String upiId = sc.next();
        System.out.println("Enter Otp :");
        sc.nextInt();
        paymentRepository.addPayment(customerId,upiId,amount);
    }
}
