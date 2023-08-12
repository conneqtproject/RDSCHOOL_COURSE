package com.rdschool.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdschool.dao.ManagerDao;
import com.rdschool.dao.UserDao;
import com.rdschool.entity.ManagerEntity;
import com.rdschool.entity.UserEntity;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ManagerEntity m = null ;
			UserEntity customer = null;
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			System.out.println(email);
			
			HttpSession session = req.getSession();
			
			if (!"admin@gmail.com".equals(email) && !"admin".equals(password)) {

				ManagerDao dao = new ManagerDao();
				m = dao.managerLogin(email, password);
				UserDao dao1 = new UserDao();
				customer = dao1.login(email, password);
			}
			
			
		
		

			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {

				session.setAttribute("adminobj", new UserEntity());
				resp.sendRedirect("admin/index.jsp");

			}else if( m != null &&m.getEmail().equals(email) && m.getPassword().equals(password)) {
				session.setAttribute("managerobj", m);
				resp.sendRedirect("manager/index.jsp");
			}else if( customer != null &&customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
				session.setAttribute("userObj", customer);
				resp.sendRedirect("index.jsp");
			}
			
			else {
				session.setAttribute("errorMsg", "invalid email & password");
				resp.sendRedirect("admin_login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
