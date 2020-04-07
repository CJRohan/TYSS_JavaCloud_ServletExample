package com.tyss.service;

import java.util.List;

import com.tyss.beans.Employee;
import com.tyss.beans.Login;
import com.tyss.dao.DAO;
import com.tyss.factory.Factory;

public class ServiceImpl implements Service {
	
	DAO dao;
	
	public ServiceImpl() {
		dao = Factory.getDAO();
	}

	@Override
	public void add(Employee employee) {
		dao.add(employee);
	}

	@Override
	public List<Employee> list() {
		return dao.list();
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void edit(Employee employee) {
		dao.edit(employee);
	}
	
	@Override
	public Boolean validate(Login user) {
		return dao.validateLogin(user);
	}
	
	

}
