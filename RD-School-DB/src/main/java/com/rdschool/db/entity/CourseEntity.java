package com.rdschool.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COURSE_DETAILS")
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String coursename;
	
}
