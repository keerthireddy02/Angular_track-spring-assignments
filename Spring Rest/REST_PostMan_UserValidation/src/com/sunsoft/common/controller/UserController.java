package com.sunsoft.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.common.model.User;


@RestController
@RequestMapping("/user")
public class UserController {
	
	List<User> user = new ArrayList<User>();
	UserController(){
		user.add(new User("sheldon","shelly"));
		user.add(new User("Keerthi","pass"));
		user.add(new User("rishikesh","hello"));
	}
	
	@RequestMapping(value="/validateuser",method=RequestMethod.POST)
	public String validateData(@RequestParam("username") String uname,@RequestParam("password") String pass){
		for(User u : user) {
			String uid=u.getUserId(),p=u.getPassword();
			if(uid.contentEquals(uname) && p.contentEquals(pass)) {
				return "Welcome "+uname;
			}
		}
		return "Invalid username or password";
	
	}

}

