package com.rdschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdschool.db.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
