package com.xsp.stu.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xsp.stu.dao.userDao;
import com.xsp.stu.dao.impl.userDaoimpl;
import com.xsp.stu.entity.User;

@WebServlet("/register")
public class service extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("username");
		userDao users=new userDaoimpl();
		List<User> list= users.Query();
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/session.jsp").forward(request, response);
		}else {
			response.sendRedirect("/login.jsp");
		}
		
		
		
	}
}
