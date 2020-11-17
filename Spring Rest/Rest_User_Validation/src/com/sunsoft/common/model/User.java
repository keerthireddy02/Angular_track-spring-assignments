package com.sunsoft.common.model;

public class User {
	
	private int uid;
	private String pass;
	
	public User(int uid,String pass) {
		this.uid=uid;
		this.pass=pass;
	}
	
	public int getUserId() {
		return uid;
	}	
	
	public void setUserId(int uid) {
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

