package com.rdschool.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdschool.dao.NoteDao;
import com.rdschool.entity.NoteEntity;

@WebServlet("/addNote")
public class AddNote  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
			String courseName=req.getParameter("cname");
			String noteName=req.getParameter("notename");
			String notePath=req.getParameter("notepath");
			
			
			
			NoteEntity n = new NoteEntity(noteName, notePath, courseName);
			
			NoteDao dao = new NoteDao();

		HttpSession session = req.getSession();

		try {
			if (dao.addNote(n)) {
	
				session.setAttribute("succMsg", "Note Added Sucessfully");
				resp.sendRedirect("manager/addnote.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("manager/addnote.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		
		
	}

	
	
	
}