package com.example.movistream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movistream.controller.UserController;

public interface UserRepository extends JpaRepository<UserController, Integer> {
	UserController findByUsername(String name);

}
