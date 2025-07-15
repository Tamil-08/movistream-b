package com.example.movistream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movistream.controller.MoviController;

public interface MoviRepository extends JpaRepository<MoviController, Integer> {

}
