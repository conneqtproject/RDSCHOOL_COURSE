package com.rdschool.entity;

public class VideoEntity {

	private int id;
	private String videoname;

	private String videopath;

	private String coursename;

	public VideoEntity() {
		super();
	}

	public VideoEntity(int id, String videoname, String videopath, String coursename) {
		super();
		this.id = id;
		this.videoname = videoname;
		this.videopath = videopath;
		this.coursename = coursename;
	}

	public VideoEntity(String videoname, String videopath, String coursename) {
		super();
		this.videoname = videoname;
		this.videopath = videopath;
		this.coursename = coursename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getVideopath() {
		return videopath;
	}

	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

}