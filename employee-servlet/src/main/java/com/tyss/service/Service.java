package com.tyss.service;

import java.util.List;

import com.tyss.beans.Employee;

public interface Service {

	void add(Employee employee);

	List<Employee> list();

	void delete(int id);

	void edit(Employee employee);
}
