package com.pilyak.testmavenproject.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/public/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Cookie cookie = new Cookie("LOGOUT", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		session.invalidate();
		request.getRequestDispatcher("/WEB-INF/request/loginForm.jsp").forward(request, response);
		//response.sendRedirect("/WEB-INF/request/loginForm.jsp");
	}
}
