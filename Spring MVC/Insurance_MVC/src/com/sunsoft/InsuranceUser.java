package com.sunsoft;


public class InsuranceUser {
	private String name;
	private String pname;
	private int tenure;
	private int amount;
	
	public InsuranceUser(String name,String pname,int tenure,int amount) {
		this.name=name;
		this.pname=pname;
		this.tenure=tenure;
		this.amount=amount;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPName(String pname){
		this.pname=pname;
	}
	
	public void setTensure(int tenure){
		this.tenure = tenure;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPName() {
		return this.pname;
	}
	
	public int getTenure() {
		return this.tenure;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	@Override
	public String toString() {
		return "Policy Name. : "+this.getPName()+"\tName : "+this.getName()+"\tAmount : "+this.getAmount()+"\tTenure : "+this.getTenure()+"|     ";
	}

}
