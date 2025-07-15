package com.example.movistream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movistream.controller.UserController;
import com.example.movistream.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;
	
	
	public void save(UserController objuser) {
	
		userrepository.save(objuser);
		
}
	
	public List<UserController> getall() {
		
		return userrepository.findAll();
	}
	public UserController getbyid(int tam) {
		return userrepository.findById(tam).get();
	}
	
	public void delid(int id) {
		userrepository.deleteById(id);
	}
	
	public void delete() {
		userrepository.deleteAll();
	}
	
	public String validate(UserController objcls) {
	    UserController currentData = userrepository.findByUsername(objcls.getUsername());

	    if (currentData == null) {
	        return "user not found";
	    }

	    if (!currentData.getPassword().equals(objcls.getPassword())) {
	        return "invalid password";
	    }

	    if (currentData.getRole().equalsIgnoreCase("admin")) {
	        return "admin";
	    } else if (currentData.getRole().equalsIgnoreCase("user")) {
	        return "user";
	    }

	    return "invalid role";
	}

}