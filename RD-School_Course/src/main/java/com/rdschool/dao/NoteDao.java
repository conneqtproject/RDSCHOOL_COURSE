package com.rdschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rdschool.db.ConnectionFactory;
import com.rdschool.entity.AcessEntity;
import com.rdschool.entity.CourseEntity;
import com.rdschool.entity.ManagerEntity;
import com.rdschool.entity.NoteEntity;

public class NoteDao {

	public boolean addNote(NoteEntity n) throws Exception {
		boolean f = false;
		
		Connection conn = ConnectionFactory.getDbConn();

		try {
			String sql = "insert into note_details(notename,notepath,coursename) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,n.getNotename());
			ps.setString(2,n.getNotepath());
			ps.setString(3, n.getCoursename());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	
	public List<NoteEntity> getAllNote() throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		List<NoteEntity> list = new ArrayList<NoteEntity>();
		NoteEntity n = null;

		try {
			String sql = "select * from note_details order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				n = new NoteEntity();
				n.setId(rs.getInt(1));
			n.setNotename(rs.getString(2));
			n.setNotepath(rs.getString(3));
			n.setCoursename(rs.getString(4));
				list.add(n);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<NoteEntity> getAllNotebyCourseName(String courseName) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		List<NoteEntity> list = new ArrayList<NoteEntity>();
		NoteEntity c = null;

		try {
			String sql = "select * from note_details where note_details = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, courseName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new NoteEntity();
				c.setId(rs.getInt(1));
				c.setNotename(rs.getString(2));
				c.setNotepath(rs.getString(3));
				c.setCoursename(rs.getString(4));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
}
