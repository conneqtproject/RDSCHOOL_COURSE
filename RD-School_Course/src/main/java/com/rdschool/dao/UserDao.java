package com.rdschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rdschool.db.ConnectionFactory;
import com.rdschool.entity.UserEntity;

public class UserDao {

	
	
	public boolean registerUser(UserEntity c) throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		boolean f = false;
		try {
			String sql = "insert into user_details(fullname,gender,age,phno,email,password,address) values(?,?,?,?,?,?,?) ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,c.getFullname());
			ps.setString(2, c.getGender());
			ps.setString(3, c.getAge());
			ps.setString(4, c.getPhno());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getPassword());
			ps.setString(7, c.getAddress());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	
	}
	
	
	
	public UserEntity login(String em, String psw) throws Exception {
		UserEntity c = null;
		Connection conn = ConnectionFactory.getDbConn();

		try {
			String sql = "select * from user_details where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new UserEntity();
				c.setId(rs.getInt(1));
				c.setFullname(rs.getString(2));
				c.setGender(rs.getString(3));
				c.setAge(rs.getString(4));
				c.setPhno(rs.getString(5));
				c.setEmail(rs.getString(6));
				c.setPassword(rs.getString(7));
				c.setAddress(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
}
	
	public List<UserEntity> getAllUser() throws Exception {
		List<UserEntity> list=new ArrayList<>();
		UserEntity c=null;
		Connection conn = ConnectionFactory.getDbConn();
		try {

			String sql = "select * from user_details order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new UserEntity();
				c.setId(rs.getInt(1));
				c.setFullname(rs.getString(2));
				c.setGender(rs.getString(3));
				c.setAge(rs.getString(4));
				c.setPhno(rs.getString(5));
				c.setEmail(rs.getString(6));
				c.setPassword(rs.getString(7));
				c.setAddress(rs.getString(8));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
			
	}
	public UserEntity getUserById(int id) throws Exception {

		UserEntity c= null;
		Connection conn = ConnectionFactory.getDbConn();
		try {

			String sql = "select * from user_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new UserEntity();
				c.setId(rs.getInt(1));
				c.setFullname(rs.getString(2));
				c.setGender(rs.getString(3));
				c.setAge(rs.getString(4));
				c.setPhno(rs.getString(5));
				c.setEmail(rs.getString(6));
				c.setPassword(rs.getString(7));
				c.setAddress(rs.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public boolean deleteUser(int id) throws Exception {
		boolean f = false;
		Connection conn = ConnectionFactory.getDbConn();
		try {
			String sql = "delete from user_details where id=?";
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
	public boolean updateUser(UserEntity c) throws Exception {
		boolean f = false;
		Connection conn = ConnectionFactory.getDbConn();

		try {
			String sql = "update user_details set fullname=?,gender=?,age=?,phno=?,email=?,password=?,address=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,c.getFullname());
			ps.setString(2, c.getGender());
			ps.setString(3, c.getAge());
			ps.setString(4, c.getPhno());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getPassword());
			ps.setString(7, c.getAddress());
			ps.setInt(8, c.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	public boolean checkUserOldPassword(int userid, String oldPassword) throws Exception {
		boolean f = false;
		Connection conn = ConnectionFactory.getDbConn();

		try {
			String sql = "select * from user_details where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changeUserPassword(int userid, String newPassword) throws Exception {
		boolean f = false;
		Connection conn = ConnectionFactory.getDbConn();

		try {
			String sql = "update user_details set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	public boolean checkUserByEmail(String em) throws Exception {
		boolean f = true;
		Connection conn = ConnectionFactory.getDbConn();
		try {
			String sql = "select * from user_details where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	public boolean checkUserByPhone(String phone) throws Exception {
		boolean f = true;
		Connection conn = ConnectionFactory.getDbConn();
		try {
			String sql = "select * from user_details where phno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
}
