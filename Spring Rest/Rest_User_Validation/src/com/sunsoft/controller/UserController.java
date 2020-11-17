package com.sunsoft.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.common.model.User;

@RestController
@RequestMapping("/login")
public class UserController {
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getDetails(@PathVariable int id) {
		
		HashMap<Integer,User> hm1=new HashMap<Integer,User>();
		hm1.put(452, new User(1,"admin"));
		hm1.put(2355, new User(2,"admin12"));
		hm1.put(3, new User(3,"admin12"));
		
		User u1=null;
		if(hm1.containsKey(id)) {
			u1=hm1.get(id);
		}
		
		if(u1.getPassword().equals("admin")) {
			return "welcome User!!!";
		}
		else {
			return "Not valid usernsme or password";
		}
	}

}
