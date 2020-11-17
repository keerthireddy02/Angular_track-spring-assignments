package com.sunsoft;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class InsuranceController {
	private static ArrayList<InsuranceUser> al=new ArrayList<InsuranceUser>();
	@RequestMapping(value="/addpolicy",method=RequestMethod.GET)
	public String addDetails(HttpServletRequest req, HttpServletResponse res,Model m) {
	
		String uname=req.getParameter("name");
		String pname=req.getParameter("pname");
		String tenure=req.getParameter("tenure");
		String amount=req.getParameter("amount");
		
		InsuranceUser iu=new InsuranceUser(uname,pname,Integer.parseInt(tenure),Integer.parseInt(amount));
		al.add(iu);
		return "adduser";
	}
	
	@RequestMapping("/displaydetails")
	public String displayDetails(Model m) {
		String userdata = "";
		for(InsuranceUser iu: al) {
			userdata+=(iu.toString()+"\n");
		}
		m.addAttribute("userdata",userdata);
		return "displaydetails";
	}

}
