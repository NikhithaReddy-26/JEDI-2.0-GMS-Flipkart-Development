package com.flipkart.gms.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Payment {
	private int customerId;
	private String upiId;
	private double amount;
	
}
