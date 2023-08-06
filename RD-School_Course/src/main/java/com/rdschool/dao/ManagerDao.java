package com.rdschool.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.rdschool.db.ConnectionFactory;
import com.rdschool.entity.ManagerEntity;

public class ManagerDao {


	
	
	
	public boolean registerManager(ManagerEntity m) throws Exception {
		boolean f = false;
		
		Connection conn = ConnectionFactory.getDbConn();

		try {
			String sql = "insert into manager_details(full_name,dob,age,email,mob_no,password) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,m.getFullName());
			ps.setString(2,m.getDob());
			ps.setString(3, m.getAge());
			ps.setString(4, m.getEmail());
			ps.setString(5, m.getMobNo());
			ps.setString(6,m.getPassword());
	
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public List<ManagerEntity> getAllManager() throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		List<ManagerEntity> list = new ArrayList<ManagerEntity>();
		ManagerEntity m = null;
		try {

			String sql = "select * from manager_details order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new ManagerEntity();
				m.setId(rs.getInt(1));
				m.setFullName(rs.getString(5));
				m.setDob(rs.getString(3));
				m.setAge(rs.getString(2));
				m.setEmail(rs.getString(4));
				m.setMobNo(rs.getString(6));
				m.setPassword(rs.getString(7));
				list.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ManagerEntity managerLogin(String em, String psw) throws Exception{
		Connection conn = ConnectionFactory.getDbConn();
		ManagerEntity m= null;

		try {
			String sql = "select * from manager_details where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				m = new ManagerEntity();
				m.setId(rs.getInt(1));
				m.setFullName(rs.getString(5));
				m.setDob(rs.getString(3));
				m.setAge(rs.getString(2));
				m.setEmail(rs.getString(4));
				m.setMobNo(rs.getString(6));
				m.setPassword(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
}
	
	public ManagerEntity getManagerById(int id) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		ManagerEntity m = null;
		try {

			String sql = "select * from manager_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				m = new ManagerEntity();
				m.setId(rs.getInt(1));
				m.setFullName(rs.getString(5));
				m.setDob(rs.getString(3));
				m.setAge(rs.getString(2));
				m.setEmail(rs.getString(4));
				m.setMobNo(rs.getString(6));
				m.setPassword(rs.getString(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	public boolean deleteManager(int id) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		boolean f = false;
		try {
			String sql = "delete from manager_details where id=?";
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
	public boolean updateManager(ManagerEntity m ) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		boolean f = false;

		try {
			String sql = "update manager_details set full_name=?,dob=?,age=?,email=?,mob_no=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(3,m.getAge());
			ps.setString(2,m.getDob());
			ps.setString(4, m.getEmail());
			ps.setString(1, m.getFullName());
			ps.setString(5, m.getMobNo());
			ps.setString(6,m.getPassword());
			ps.setInt(7, m.getId());
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
