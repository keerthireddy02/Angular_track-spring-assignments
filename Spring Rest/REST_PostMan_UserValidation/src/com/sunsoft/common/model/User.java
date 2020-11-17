package com.sunsoft.common.model;

public class User {
	
	private String uid;
	private String pass;
	
	public User(String uid,String pass) {
		this.uid=uid;
		this.pass=pass;
	}
	
	public String getUserId() {
		return uid;
	}	
	
	public void setUserId(String uid) {
		this.uid=uid;
	}
	
	public String getPassword() {
		return pass;
	}	
	
	public void setPassword(String pass) {
		this.pass=pass;
	}
	
	public String toString() {
		if(pass=="admin")
			return "successful";
		else
			return "Not valid user";
	}

}

