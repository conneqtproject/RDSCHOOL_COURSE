package com.rdschool.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdschool.dao.CourseDao;
import com.rdschool.dao.ManagerDao;
import com.rdschool.entity.CourseEntity;
import com.rdschool.entity.ManagerEntity;

@WebServlet("/updateCourse")
public class UpdateCourse extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String courseName = req.getParameter("coursename");
			

			int id = Integer.parseInt(req.getParameter("id"));

			CourseEntity c = new CourseEntity(id, courseName);

			CourseDao dao = new CourseDao();
			HttpSession session = req.getSession();

			if (dao.updateCourse(c)) {
				session.setAttribute("succMsg", "Course Update Sucessfully..");
				resp.sendRedirect("admin/view_course.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/view_course.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}