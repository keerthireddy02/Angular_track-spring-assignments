package com.sunsoft;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	private static Map<Integer, Student> student = new HashMap<Integer, Student>();
	private int c = 1;
	@RequestMapping("addstudent")
	public String addStudent(HttpServletRequest req, HttpServletResponse res, Model m) {
		int id=Integer.parseInt(req.getParameter("id"));
		Student s=new Student(id, req.getParameter("fname"), req.getParameter("lname"),req.getParameter("branch"));
		student.put(id,s);
		c++;
		return "addstudent";
		
	}
	
	@RequestMapping("deletestudent")
	public String deleteStudent(HttpServletRequest req, HttpServletResponse res, Model m) {
		
		int id = Integer.parseInt(req.getParameter("id"));
		Student s = (Student)student.remove(id);
		m.addAttribute("deletedstudent", s);
		return "deletestudent";
		
	}
	
	@RequestMapping("updatestudent")
	public String updateStudent(HttpServletRequest req, HttpServletResponse res, Model m) {

		int id = Integer.parseInt(req.getParameter("id"));
		String branch = req.getParameter("branch");
		Student s = student.get(id);
		s.setBranch(branch);
		return "updatestudent";
		
	}
	
	@RequestMapping("/displaystudents")
	public String newController(Model m) {
		String str = "";
		for (Map.Entry<Integer, Student> s : student.entrySet()) {
			str+=(s.getValue().toString()+"...........");
		}
		m.addAttribute("students",str);
		return "displaystudents";
	}
}

