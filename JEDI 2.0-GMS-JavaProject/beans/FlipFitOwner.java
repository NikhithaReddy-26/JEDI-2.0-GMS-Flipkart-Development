package com.flipkart.gms.beans;

public class FlipFitOwner {

	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "FlipFitOwner [name=" + name + ", password=" + password + "]";
	}
	
}
