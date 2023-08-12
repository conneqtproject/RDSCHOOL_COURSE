package com.rdschool.entity;

public class AcessEntity {

	private int id;
	private String email;

	

	private String coursename;
	
	private String imagePath;

	public AcessEntity() {
		super();
	}

	
	
	
	public AcessEntity(int id, String email, String coursename, String imagePath) {
		super();
		this.id = id;
		this.email = email;
		this.coursename = coursename;
		this.imagePath = imagePath;
	}




	public AcessEntity(String email, String coursename, String imagePath) {
		super();
		this.email = email;
		this.coursename = coursename;
		this.imagePath = imagePath;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	

}