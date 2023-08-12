package com.rdschool.entity;

public class NoteEntity {

	private int id;
	private String notename;

	private String notepath;

	private String coursename;

	public NoteEntity() {
		super();
	}

	public NoteEntity(int id, String notename, String notepath, String coursename) {
		super();
		this.id = id;
		this.notename = notename;
		this.notepath = notepath;
		this.coursename = coursename;
	}

	public NoteEntity(String notename, String notepath, String coursename) {
		super();
		this.notename = notename;
		this.notepath = notepath;
		this.coursename = coursename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotename() {
		return notename;
	}

	public void setNotename(String notename) {
		this.notename = notename;
	}

	public String getNotepath() {
		return notepath;
	}

	public void setNotepath(String notepath) {
		this.notepath = notepath;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

}