package com.rdschool.db;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	 private static DataSource ds=null;
	 
	 static {
		 
		 try {
			
		
		String url="jdbc:mysql://rdschool-test.c5ctt9cop75m.ap-south-1.rds.amazonaws.com:3306/rdschooltest";
		String uname="admin";
		String pwd="admin1234";
		String poolsize="20";
		String driver ="com.mysql.cj.jdbc.Driver";
		HikariConfig config=new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(uname);
		config.setPassword(pwd);
		config.setDriverClassName(driver);
		config.setMaximumPoolSize(Integer.parseInt(poolsize));
		
		ds=new HikariDataSource(config);
			 	 System.out.println("Connection Sucess");
		 }catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 public static Connection getDbConn() throws Exception {
		return ds.getConnection();
		 
	 }

	 public static void main(String[] args) throws Exception {
		getDbConn();
	}

	}