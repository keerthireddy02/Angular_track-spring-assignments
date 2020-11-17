package com.sunsoft.common.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fullname")
public class UserController {
	@RequestMapping(value="/{fname}/{lname}", method=RequestMethod.GET)
	public String validateUser(@PathVariable String fname, @PathVariable String lname) {
		return fname+" "+lname;
	}
}