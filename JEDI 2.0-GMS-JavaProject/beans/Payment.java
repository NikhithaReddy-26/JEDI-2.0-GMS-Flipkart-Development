package com.flipkart.gms.beans;

import com.flipkart.gms.utils.PaymentMode;

public class Payment {

	private int transactionId;
	private double amount;
	private PaymentMode mode;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PaymentMode getMode() {
		return mode;
	}
	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}
	
}
