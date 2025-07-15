package com.example.movistream.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movistream.controller.MoviController;
import com.example.movistream.repository.MoviRepository;

@Service
public class MoviService {
	@Autowired
	private MoviRepository  movierepository;
	
	public void save(MoviController objmovi) {
		
		movierepository.save(objmovi);
	}
	
	public List<MoviController> allreviews(){
		
		return movierepository.findAll();
	}
	
	
	public void update(int sam, MoviController updateData) {
		MoviController data = movierepository.findById(sam).get();
		
		data.setName(updateData.getName());
		data.setNum(updateData.getNum());
		data.setMail(updateData.getMail());
		data.setMessage(updateData.getMessage());
		
		movierepository.save(data);
		
				
	}
	
	public void delete(int id) {
		
		movierepository.deleteById(id);
		
	}
	
	public void deleteall() {
		movierepository.deleteAll();
	}
}

