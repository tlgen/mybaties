package com.mybatis.ssm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.ssm.bean.Employee;
import com.mybatis.ssm.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/getEmps")
	public String getEmps(Map<String, Object> map) {
		
		List<Employee> emps = employeeService.getEmps();
		map.put("emps",emps);	
		return "list";
		
	}

}
