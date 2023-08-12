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

public class AcessDao {
	
	public boolean addCourse(AcessEntity a)  {
		Connection conn;
		boolean f = false;
		try {
			conn = ConnectionFactory.getDbConn();
			
			try {
				String sql = "insert into access_details(course_name,email,image) values(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, a.getCoursename());
				ps.setString(2, a.getEmail());
				ps.setString(3, a.getImagePath());

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

	public List<AcessEntity> getAllCourse(String email) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		List<AcessEntity> list = new ArrayList<AcessEntity>();
		AcessEntity c = null;

		try {
			String sql = "select * from access_details where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new AcessEntity();
				c.setId(rs.getInt(1));
				c. setCoursename(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setImagePath(rs.getString(4));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	public List<AcessEntity> getAllCourseAcess() throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		List<AcessEntity> list = new ArrayList<AcessEntity>();
		AcessEntity c = null;

		try {
			String sql = "select * from access_details order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new AcessEntity();
				c.setId(rs.getInt(1));
				c. setCoursename(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setImagePath(rs.getString(4));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public AcessEntity getGrantAcesseById(int id) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		AcessEntity m = null;
		try {

			String sql = "select * from access_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				m = new AcessEntity();
				m.setId(rs.getInt(1));
				m.setCoursename(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setImagePath(rs.getString(4));
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	public boolean deleteGrantAcess(int id) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		boolean f = false;
		try {
			String sql = "delete from access_details where id=?";
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
	public boolean updateGrantAcess(AcessEntity m ) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		boolean f = false;

		try {
			String sql = "update access_details set course_name=?,email = ?, image =? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,m.getCoursename());
			ps.setString(2, m.getEmail());
			ps.setString(3, m.getImagePath());
			
			ps.setInt(4, m.getId());
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