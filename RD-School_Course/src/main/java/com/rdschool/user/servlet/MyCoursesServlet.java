package com.rdschool.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rdschool.dao.AcessDao;
import com.rdschool.entity.AcessEntity;

@WebServlet("/usercourse")
public class MyCoursesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the logged-in user's email from the session
		String userEmail = request.getParameter("email");

		System.out.println("User Email: " + userEmail);

		// Retrieve the courses that the user has access to from the database

		AcessDao dao = new AcessDao();
		try {
			List<AcessEntity> userCourses = dao.getAllCourse(userEmail);

			request.setAttribute("userCourses", userCourses);
			request.getRequestDispatcher("/my-courses.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
