package com.rdschool.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String fullname;
	private String gender;
	private String age;
	private String phno;
	private String email;
	private String password;
	private String address;
	
}
