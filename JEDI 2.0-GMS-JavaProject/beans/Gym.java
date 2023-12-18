package com.flipkart.gms.beans;

import lombok.Data;

@Data
public class Gym
{
	private int id;
	private int gymOwnerId;
	private String name;
	private String location;
	private int noOfSeats;
	private boolean isApproved;
	private double amount;
}
