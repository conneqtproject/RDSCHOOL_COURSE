package com.rdschool.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdschool.dao.NoteDao;
import com.rdschool.dao.VideoDao;
import com.rdschool.entity.NoteEntity;
import com.rdschool.entity.VideoEntity;

@WebServlet("/addVideo")
public class AddVideo  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
			String courseName=req.getParameter("cname");
			String videoName=req.getParameter("videoname");
			String videoPath=req.getParameter("videopath");
			
			
			
			VideoEntity v = new VideoEntity(videoName, videoPath, courseName);
			
			VideoDao dao = new VideoDao();

		HttpSession session = req.getSession();

		try {
			if (dao.addVideo(v)) {
	
				session.setAttribute("succMsg", "Video Added Sucessfully");
				resp.sendRedirect("manager/addVideo.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("manager/addVideo.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		
		
	}

	
	
	
}