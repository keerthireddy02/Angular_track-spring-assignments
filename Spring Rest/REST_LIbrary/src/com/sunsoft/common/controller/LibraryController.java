package com.sunsoft.common.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.common.model.Library;



@RestController
@RequestMapping("/library")
public class LibraryController {
	
	Map<Integer, Library> lib = new HashMap<Integer,Library>();
	public LibraryController(){
		lib.put(1,new Library(1,"Harry Potter I",2000));
		lib.put(2,new Library(2,"Harry Potter II",2002));
		lib.put(3,new Library(3,"Harry Potter III",2004));
		lib.put(1,new Library(1,"Harry Potter IV",2006));
		lib.put(1,new Library(1,"Harry Potter V",2008));
		
	}
	
	@RequestMapping("display_all")
	public String getBookDetails() {
		String book = "";
		for (Map.Entry<Integer, Library> m : lib.entrySet()) 
            book+=m.getValue().toString()+"\n";
		return book;
	}
	
	@RequestMapping("/{id}")
	public String getBookDetails(@PathVariable int id) {
		Library book = lib.get(id);
		return book.toString();
	}
	
}

