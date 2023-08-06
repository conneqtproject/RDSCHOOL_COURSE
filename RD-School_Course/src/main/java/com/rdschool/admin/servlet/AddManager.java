package com.rdschool.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdschool.dao.ManagerDao;
import com.rdschool.entity.ManagerEntity;

@WebServlet("/addManager")
public class AddManager extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String age = req.getParameter("age");
			
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");
			String password = req.getParameter("password");

			ManagerEntity m = new ManagerEntity(fullName, dob,age, email, mobno, password);

			ManagerDao dao = new ManagerDao();
			HttpSession session = req.getSession();

			if (dao.registerManager(m)) {
				session.setAttribute("succMsg", "Manager Added Sucessfully..");
				resp.sendRedirect("admin/manager.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/manager.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}