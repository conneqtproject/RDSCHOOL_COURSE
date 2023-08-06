package com.rdschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rdschool.db.ConnectionFactory;
import com.rdschool.entity.CourseEntity;
import com.rdschool.entity.ManagerEntity;

public class CourseDao {
	
	public boolean addCourse(String courseName)  {
		Connection conn;
		boolean f = false;
		try {
			conn = ConnectionFactory.getDbConn();
			
			try {
				String sql = "insert into course_details(coursename) values(?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, courseName);

				int i = ps.executeUpdate();
				if (i == 1) {
					f = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		return f;
	}

	public List<CourseEntity> getAllCourse() throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		List<CourseEntity> list = new ArrayList<CourseEntity>();
		CourseEntity c = null;

		try {
			String sql = "select * from course_details order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new CourseEntity();
				c.setId(rs.getInt(1));
				c. setcoursename(rs.getString(2));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	public CourseEntity getCourseById(int id) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		CourseEntity m = null;
		try {

			String sql = "select * from course_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				m = new CourseEntity();
				m.setId(rs.getInt(1));
				m.setcoursename(rs.getString(2));
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	public boolean deleteCourse(int id) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		boolean f = false;
		try {
			String sql = "delete from course_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	public boolean updateCourse(CourseEntity m ) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		boolean f = false;

		try {
			String sql = "update course_details set coursename=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,m.getcoursename());
			
			ps.setInt(2, m.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	

}