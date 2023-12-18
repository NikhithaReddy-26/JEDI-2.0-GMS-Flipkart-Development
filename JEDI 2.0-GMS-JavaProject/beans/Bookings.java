package com.flipkart.gms.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookings {
	private int id;
	private int gymCenterId;
	private int slotId;
	private int customerId;
	private String date;
}
