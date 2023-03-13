package com.ashokit.jdbc.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.jdbc.dao.EmpDAO;

@Component
public class MyAppRunner implements CommandLineRunner {

	@Autowired
	EmpDAO dao;

	@Override
	public void run(String... args) throws Exception {

		boolean flag = dao.addEmployee(6001, "Hiranya Pawar", 55000.0, 60);
		if (flag) {
			System.out.println("Employee is added to DB");
		} else {
			System.out.println("Employee already exist");
		}

		/*
		 * Map<String, Object> empMap = dao.findEmployeeById(1001); //
		 * System.out.println(empMap); empMap.entrySet().stream().forEach(entry ->
		 * System.out.println(entry.getKey() + " : " + entry.getValue()));
		 */
	}

}
