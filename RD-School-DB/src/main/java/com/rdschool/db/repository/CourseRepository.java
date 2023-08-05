package com.rdschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdschool.db.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>{

}
