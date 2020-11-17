package com.sunsoft;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.common.model.Employee;

@RestController
@RequestMapping("/payroll")
public class EmployeeController {
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getMovie(@PathVariable int id) {
		
		HashMap<Integer,Employee> hm1=new HashMap<Integer,Employee>();
		hm1.put(1, new Employee(1,"keerthi",55000,3500,2000,200));
		hm1.put(2, new Employee(2,"Harshitha",65000,3500,2000,200));
		hm1.put(3, new Employee(3,"Vivek",55000,5500,2000,200));
		
		Employee emp=null;
		if(hm1.containsKey(id)) {
			emp=hm1.get(id);
		}
		
		emp.setGross_sal(emp.getBasic()+emp.getAllowance()+emp.getHra());
		emp.setFinal_deductions((int)(emp.getDeductions()+(emp.getGross_sal()*0.2)));
		emp.setTotal_sal(emp.getGross_sal()-emp.getFinal_deductions());
		
		return emp.toString();
		
		
	}
	
	@RequestMapping(value="/display",method=RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name){
		System.out.println(name);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
