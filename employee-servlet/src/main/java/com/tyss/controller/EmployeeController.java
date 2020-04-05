package com.tyss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.beans.Employee;
import com.tyss.factory.Factory;
import com.tyss.service.Service;

@SuppressWarnings("serial")
public class EmployeeController extends HttpServlet{

	private Service service;
	
	public EmployeeController() {
		service = Factory.getService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String action = req.getParameter("action");
		writer.print(action);
		RequestDispatcher dispatcher = null;
		switch(action) {
		case "LOGIN":
			if (req.getParameter("admin").equalsIgnoreCase("chandan") 
					&& req.getParameter("pass").equalsIgnoreCase("thankyou")) {
				dispatcher = req.getRequestDispatcher("/welcome.jsp");
				dispatcher.forward(req, resp);								
			} else {
				req.setAttribute("message", "Invalid Credentials.. Please try again!!!");
				dispatcher = req.getRequestDispatcher("/login.jsp");
				dispatcher.forward(req, resp);
			}
			break;
		case "WELCOME":
			dispatcher = req.getRequestDispatcher("/welcome.jsp");
			dispatcher.forward(req, resp);			
			break;
		case "LIST":
			writer.print("LISTING");
			req.setAttribute("employees", service.list());
			dispatcher = req.getRequestDispatcher("/list.jsp");
			dispatcher.forward(req, resp);
			break;
		case "ADD":
			writer.print(action);
			dispatcher = req.getRequestDispatcher("/add.jsp");
			dispatcher.forward(req, resp);
			break;
		case "ADDEmployee":
			writer.print(action);
			Employee employee = new Employee();
			employee.setName(req.getParameter("name"));
			employee.setMailid(req.getParameter("mail"));
			employee.setPassword(req.getParameter("password"));
			employee.setSex(req.getParameter("sex"));
			employee.setCountry(req.getParameter("country"));
			if (req.getParameter("id") == "") {
				service.add(employee);
				req.setAttribute("message", "Employee Added succesfully!!!");
			} else {
				employee.setEmpid(Integer.parseInt(req.getParameter("id")));
				service.edit(employee);
				req.setAttribute("message", "Employee Updated succesfully!!!");
			}
			dispatcher = req.getRequestDispatcher("/add.jsp");
			dispatcher.forward(req, resp);
			break;
		case "EDIT":
			writer.print(action);
			req.setAttribute("id", req.getParameter("id"));
			req.setAttribute("password", req.getParameter("password"));
			req.setAttribute("name", req.getParameter("name"));
			req.setAttribute("mail", req.getParameter("mail"));
			req.setAttribute("sex", req.getParameter("sex"));
			req.setAttribute("country", req.getParameter("country"));
			dispatcher = req.getRequestDispatcher("/add.jsp");
			dispatcher.forward(req, resp);
			break;
		case "DELETE":
			writer.print(action);
			service.delete(Integer.parseInt(req.getParameter("id")));
			System.out.println(req.getParameter("id"));
			req.setAttribute("employees", service.list());
			req.setAttribute("message", "Record Deleted Successfully!!!");
			dispatcher = req.getRequestDispatcher("/list.jsp");
			dispatcher.forward(req, resp);
			break;
		case "LOGOUT":
			req.setAttribute("message", "You have sucessfully logged out!!!");
			dispatcher = req.getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);			
		default:
			writer.print("UnderATTACK");
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
