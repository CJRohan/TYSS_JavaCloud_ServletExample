package com.tyss.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empid;
	@Column
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(unique = true)
	private String mailid;
	@Column
	private String sex;
	@Column
	private String country;

	public Employee() {

	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", password=" + password + ", mailid=" + mailid
				+ ", sex=" + sex + ", country=" + country + "]";
	}
	
	
	

}
