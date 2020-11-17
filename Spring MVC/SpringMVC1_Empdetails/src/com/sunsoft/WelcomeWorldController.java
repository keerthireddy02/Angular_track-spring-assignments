package com.sunsoft;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeWorldController {
	
	@RequestMapping("/welcome/{id1}")
	public String helloWorld(@RequestParam ("id") int id, @RequestParam ("name") String name, @PathVariable("id1") int id1, Model m) {
		String message="Given data ID: "+id+" Name: "+name+" Path variable data :"+id1;
		m.addAttribute("message",message);
		m.addAttribute("test","test");
		
		return "welcomepage";
	}

}
