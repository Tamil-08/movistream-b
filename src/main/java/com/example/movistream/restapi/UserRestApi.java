package com.example.movistream.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movistream.controller.UserController;
import com.example.movistream.service.UserService;
@RestController
@CrossOrigin
public class UserRestApi {
@Autowired
	private UserService userservice;
	
	@PostMapping("/use")
	public void use(@RequestBody UserController user ) {
		
		userservice.save(user);
	}
	
	@GetMapping("/getbyid/{id}")
	public UserController getbyid(@PathVariable int id) {
		return userservice.getbyid(id);	
	}
	
	@GetMapping("/getal")
	public List<UserController> getall() {
		return userservice.getall();
	}
	
	@DeleteMapping("/deleteid/{id}")
	public void del(@PathVariable int id) {
		userservice.delid(id);
	}
	@DeleteMapping("/delete")
	public void dell() {
		userservice.delete();
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserController objclass) {
		String res = userservice.validate(objclass);
		return res;
	}
}
