package com.rdschool.entity;


public class CourseEntity {
	
	private int id;
	private String coursename;
	public CourseEntity() {
		super();
	}
	public CourseEntity(int id, String coursename) {
		super();
		this.id = id;
		this.coursename = coursename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcoursename() {
		return coursename;
	}
	public void setcoursename(String coursename) {
		this.coursename = coursename;
	}
	
	
	

}