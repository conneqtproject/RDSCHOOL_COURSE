package com.rdschool.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdschool.dao.UserDao;
import com.rdschool.entity.UserEntity;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fullname = req.getParameter("fullname");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");
			String phno = req.getParameter("phno");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String address = req.getParameter("address");

			UserEntity c = new UserEntity(fullname, gender, age, phno, email, password, address);
			UserDao dao=new UserDao();
			
			HttpSession session = req.getSession();

			boolean f2=dao.checkUserByEmail(email);
			if (f2) {
			boolean f3=dao.checkUserByPhone(phno);
			if (f3) {
				boolean f = dao.registerUser(c);

				if (f) {

					session.setAttribute("sucmsg", "Register Sucessfully");
					resp.sendRedirect("signup.jsp");

				} else {
					session.setAttribute("errorMsg", "Something wrong on server");
					resp.sendRedirect("signup.jsp");
				}

			}else {
				session.setAttribute("errorMsg", "User Already Exist Try Another Phone Number");
				resp.sendRedirect("signup.jsp");
			}
			}else {
				session.setAttribute("errorMsg", "User Already Exist Try Another Email Id");
				resp.sendRedirect("signup.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}