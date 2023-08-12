package com.rdschool.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.rdschool.dao.AcessDao;
import com.rdschool.entity.AcessEntity;

@WebServlet("/grantAccess")
@MultipartConfig
public class AdminGrantAccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("email");
        String courseName = request.getParameter("courseName");
        Part p1=request.getPart("image");
		String imagePath=p1.getSubmittedFileName();

        AcessEntity e = new AcessEntity(userEmail, courseName,imagePath);
        
        AcessDao dao = new AcessDao();
        HttpSession session = request.getSession();
        
        if (dao.addCourse(e)) {
        	String path=getServletContext().getRealPath("")+"courseimage";
			File file=new File(path);
			
			p1.write(path+File.separator+imagePath);
			
			session.setAttribute("succMsg", "Acess Give Sucessfully..");
			response.sendRedirect("admin/useracess.jsp");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			response.sendRedirect("admin/useracess.jsp");
		}
    
    }
}
