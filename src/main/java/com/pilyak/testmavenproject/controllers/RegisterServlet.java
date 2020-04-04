package com.pilyak.testmavenproject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pilyak.testmavenproject.dao.UserDao;
import com.pilyak.testmavenproject.dao.impl.DefaultUserDao;
import com.pilyak.testmavenproject.models.UserData;
import static com.pilyak.testmavenproject.filters.PartnerFilter.*;

@WebServlet("/public/signup")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/request/signupForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserData user = new UserData();
		user.setEmail(request.getParameter("userEmail"));
		user.setFirstName(request.getParameter("name"));
		user.setLastName(request.getParameter("surname"));
		user.setPassword(request.getParameter("pass"));
		user.setBirthday(request.getParameter("birthday"));
		//user.setGender(request.getParameter("gender"));
		//TODO: addUserValidator; boolean isValid() || return error list
		//request.getCookies();
		user.setGender(request.getParameter("gender"));
		
		for (Cookie  c : request.getCookies()) {
			if(c.getName().equals(PARTNER_ID)) {
				user.setReferId(c.getValue());
				System.out.println(c.getValue());
			}
		}
		
		
		userDao.addUser(user);
		request.setAttribute("logUser", user);
		request.getRequestDispatcher("/WEB-INF/request/profileForm.jsp").forward(request, response);
		
		//response.sendRedirect(getServletContext().getContextPath() + "/profileForm");
		//doGet(request, response);
	}

}
