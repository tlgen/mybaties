package mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.bean.Employee;
import mybatis.dao.EmployeeMapper;

public class MybatisTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);		
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void getEmpById() throws IOException {
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
			System.out.println(employee.getClass());
			
		}finally {
			openSession.close();
		}
		
	}
	
	@Test
	public void addEmp() throws IOException {
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(null,"lala","ww@163.com","1");
			mapper.addEmp(employee);
			
			openSession.commit();
			System.out.println(employee.getId());
		}finally {
			openSession.close();
		}
		
	}
	
	@Test
	public void delete() throws IOException {
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			mapper.delete(2);
			openSession.commit();
			
		}finally {
			openSession.close();
		}
	}
	
	@Test
	public void update() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSesssion = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSesssion.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(3,"Ó††Î","ee@163.com","0");
			boolean updateEmp = mapper.updateEmp(employee);
			System.out.println(updateEmp);
			mapper.updateEmp(employee);
			openSesssion.commit();
		}finally {
			openSesssion.close();
		}
	}
	
	@Test
	public void getEmpByIdAndLastName() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpByIdAndLastName(4, "lala");
			
			System.out.println(employee.getEmail());
			
		}finally {
			
			openSession.close();
	
		}
	}
	
	@Test
	public void getEmpByLastNameLike() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
			List<Employee> like = mapper.getEmpByLastNameLike("%a%");
			
			for (Employee employee : like) {
				
				System.out.println(employee.getLastName());
			}
			
			
		}finally {
			
			openSession.close();
	}
	}

	@Test
	public void getEmpByLastNameLikeReturnMap() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
			Map<String, Employee> map = mapper.getEmpByLastNameLikeReturnMap("%l%");
			
			System.out.println(map.toString());
		}finally {
			
			openSession.close();
		}
	}
	
	@Test
	public void getEmpAndDept() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
			Employee empAndDept = mapper.getEmpAndDept(1);
			
			System.out.println(empAndDept.getEmail());
		}finally {
			
		}
	}

}
