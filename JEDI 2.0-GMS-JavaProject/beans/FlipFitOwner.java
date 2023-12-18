package com.flipkart.gms.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FlipFitOwner extends User{

	private String address;
	private String email;
	private long phone;
	private String gstNumber;
	private boolean isApproved;
}
