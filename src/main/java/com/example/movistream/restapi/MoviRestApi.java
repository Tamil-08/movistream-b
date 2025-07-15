package com.example.movistream.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movistream.controller.MoviController;
import com.example.movistream.service.MoviService;

@RestController
@CrossOrigin
public class MoviRestApi {
	@Autowired
	private MoviService moviservice;
	
	@PostMapping("/create")
	public String create(@RequestBody MoviController objmovi) {
		
		moviservice.save(objmovi);
		return " movi Details is saved ";
		
		
	}

	@GetMapping("/greet")
	public String greet() {
		return "Hello San!";
		
	}

@GetMapping("/get")
public List<MoviController> allreviews() {
	
	return moviservice.allreviews();
	
	
}
	
@PutMapping("/{sam}")
public String sam(@PathVariable int sam, @RequestBody MoviController data) {
	moviservice.update(sam, data);
	return "All Details updated";

}

@DeleteMapping("/{id}")
public String id(@PathVariable int id) {
	moviservice.delete(id);
	return " deleted";
}

@DeleteMapping("/deleteall")
public String id() {
	moviservice.deleteall();
return "All Details is deleted";
}
}