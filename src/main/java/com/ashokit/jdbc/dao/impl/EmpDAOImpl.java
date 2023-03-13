package com.ashokit.jdbc.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ashokit.jdbc.dao.EmpDAO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	@Override
	public boolean addEmployee(Integer empno, String ename, Double sal, Integer deptno) {
		String sqlQuery = "INSERT INTO EMP VALUES (?, ?, ?, ?)";
		try {
			jdbcTemplate.update(sqlQuery, empno, ename, sal, deptno);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public Map<String, Object> findEmployeeById(Integer empno) {
		System.out.println("DataSource class : "+ jdbcTemplate.getDataSource().getClass().getName());
		String sqlQuery = "SELECT * FROM EMP WHERE EMPNO = ?";
		return jdbcTemplate.queryForMap(sqlQuery, empno);
	}

	@Override
	public boolean updateEmployee(Integer empno, Double sal) {
		String sqlQuery = "UPDATE EMP SET SAL = ? WHERE EMPNO = ?";
		try {
			jdbcTemplate.update(sqlQuery, sal, empno);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteEmployeeById(Integer empno) {
		String sqlQuery = "DELETE FROM EMP WHERE EMPNO = ?";
		try {
			jdbcTemplate.update(sqlQuery, empno);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
