package com.tyss.dao;

import java.util.List;

import com.tyss.beans.Employee;

public interface DAO {
	
	void add(Employee employee);
	
	List<Employee> list();

	void delete(int id);

	void edit(Employee employee);

	
}
