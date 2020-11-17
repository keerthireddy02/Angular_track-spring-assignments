package com.sunsoft.common.model;

public class Library {

	private int isbn;
	private String name;
	private int p_year;
	
	public Library() {
	}
	
	public Library(int isbn, String name, int p_year) {
		this.isbn=isbn;
		this.name = name;
		this.p_year=p_year;
	}
	
	public void setISBN(int isbn) {
		this.isbn=isbn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPublishesYear(int p_year) {
		this.p_year=p_year;
	}
	
	public int getISBN() {
		return this.isbn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPublishedYear() {
		return this.p_year;
	}
	
	@Override
	public String toString() {
		return "ISBN : "+this.getISBN()+"\tName : "+this.getName()+"\tPublishes Year : "+this.getPublishedYear();
	}
	
}
