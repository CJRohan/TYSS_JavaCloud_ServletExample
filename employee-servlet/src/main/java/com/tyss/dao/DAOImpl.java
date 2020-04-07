package com.tyss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tyss.beans.Employee;
import com.tyss.beans.Login;

public class DAOImpl implements DAO {

	@Override
	public void add(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(employee);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public List<Employee> list() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return employees;
	}

	@Override
	public void delete(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("delete from Employee where empid = " + id);
		query.executeUpdate();

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

	}

	@Override
	public void edit(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("update Employee set name = '" + employee.getName() + "', mailid = '"
				+ employee.getMailid() + "', password = '" + employee.getPassword() + "', sex = '" + employee.getSex()
				+ "', country = '" + employee.getCountry() + "' where empid = '" + employee.getEmpid() + "'");
		query.executeUpdate();

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Override
	public Boolean validateLogin(Login user) {
		return user.getAdmin().equalsIgnoreCase("chandan") && user.getPassword().equalsIgnoreCase("thankyou");
	}

}
