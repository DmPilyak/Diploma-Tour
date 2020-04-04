package com.pilyak.testmavenproject.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pilyak.testmavenproject.dao.UserDao;
import com.pilyak.testmavenproject.dao.impl.DefaultUserDao;
import com.pilyak.testmavenproject.models.UserData;

//@WebServlet("/Login")
public class LoginController extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getInstance(); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/request/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		UserData user = userDao.getUserByEmail(email);
		if(user != null && user.getPassword().equals(pass)) {
			session = request.getSession();
			session.setAttribute("userEmail", email);
			request.setAttribute("logUser", user);
			request.getRequestDispatcher("/WEB-INF/request/profileForm.jsp").forward(request, response);
		} else {
			request.setAttribute("errorLog", "E-mail or password is incorrect!");
			request.getRequestDispatcher("/WEB-INF/request/loginForm.jsp").forward(request, response);
		}
			
		
		//response.sendRedirect(getServletContext().getContextPath() + "/profileForm");
	}

}
