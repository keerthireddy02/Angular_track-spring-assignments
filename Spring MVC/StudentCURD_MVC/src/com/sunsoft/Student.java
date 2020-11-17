package com.sunsoft;


public class Student{
	
	private int id;
	private String firstName;
	private String lastName;
	private String branch;
	
	
	public Student() {}
	public Student(int id, String fname, String lname, String branch) {
		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
		this.branch = branch;
		
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String toString() {
		return "ID: "+getId()+"-----Name: "+getFirstName()+" "+getLastName()+"------Branch: "+getBranch();
	}

}