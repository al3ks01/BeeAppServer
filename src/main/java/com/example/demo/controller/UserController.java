package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

public class UserController {

	@Autowired IUserService userService;
	
	@RequestMapping("/consultar")
	public ResponseEntity<List<User>> getUsuarios(){
		return new ResponseEntity<>(userService.findAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/insertar")
	public ResponseEntity<User> insert(@RequestBody User u){
		ResponseEntity<User> response = new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
		
		if (userService.insert(u)) {
			response = new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		} 
		
		return response;
	}
}
