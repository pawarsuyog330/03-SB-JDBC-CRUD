package com.ashokit.jdbc.dao;

import java.util.Map;

public interface EmpDAO {
	
	boolean addEmployee(Integer empno, String ename, Double sal, Integer deptno);
	Map<String, Object>  findEmployeeById(Integer empno);
	boolean updateEmployee(Integer empno, Double sal);
	boolean deleteEmployeeById(Integer empno);

}
