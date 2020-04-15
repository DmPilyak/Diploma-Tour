package com.pilyak.testmavenproject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pilyak.testmavenproject.dao.TourDao;
import com.pilyak.testmavenproject.dao.impl.DefaultTourDao;
import com.pilyak.testmavenproject.models.TourData;


@WebServlet("/public/toursList")
public class ToursList extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
private TourDao tourDao;
	
	{
		tourDao = DefaultTourDao.getInstance(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TourData> tours = tourDao.getAllTours();
		System.out.println(tours);
		request.setAttribute("tourArray", tours);
		request.getRequestDispatcher("/WEB-INF/request/tourForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
