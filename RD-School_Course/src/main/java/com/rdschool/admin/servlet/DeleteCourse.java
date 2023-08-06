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

@WebServlet("/deleteCourse")
public class DeleteCourse extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		CourseDao dao = new CourseDao();
		HttpSession session = req.getSession();

		try {
			if (dao.deleteCourse(id)) {
				session.setAttribute("succMsg", "Course Delete Sucessfully..");
				resp.sendRedirect("admin/view_course.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/view_course.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}