package com.mybatis.ssm.dao;

import java.util.List;

import com.mybatis.ssm.bean.Employee;

public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps();

}
