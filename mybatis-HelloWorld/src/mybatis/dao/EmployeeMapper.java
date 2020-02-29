package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import mybatis.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);
	
	public Long addEmp(Employee employee);
	
	public void delete(Integer id);
	
	public boolean updateEmp(Employee employee);
	
	public Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	
	public List<Employee> getEmpByLastNameLike(String lastName);
	
	@MapKey("lastName")
	public Map<String, Employee> getEmpByLastNameLikeReturnMap(String map);
	
	public Employee getEmpAndDept(Integer id);
	
}
