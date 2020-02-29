package com.mybatis.ssm.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.ssm.bean.Employee;
import com.mybatis.ssm.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> getEmps(){
		
		return employeeMapper.getEmps();

	}
	
}
