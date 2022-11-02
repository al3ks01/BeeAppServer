package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("beeapp/user")
@CrossOrigin
public class UserControllerRest {

	@Autowired IUserService userService;
	
	@GetMapping("/consult")
	public ResponseEntity<List<User>> getUsers(){
		
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<User> insertUser(@Valid @RequestBody User user){
		
		HttpStatus status = HttpStatus.CREATED;
		
		
		if (!userService.insert(user)) {
			status = HttpStatus.BAD_REQUEST;
		} 
		
		
		return new ResponseEntity<>(user, status);
	}
	
	@GetMapping("/consult/{uid}")
	public ResponseEntity<User> getUser(@PathVariable("uid") String uid){
		
		ResponseEntity<User> response;
		Optional<User> user;
		
		user = userService.findByUid(uid);
		
		if(user.isPresent()) {
			response = new ResponseEntity<>(user.get(), HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		return response;
				
	}
	@PutMapping ("/update")
	public ResponseEntity<User> updateUser (@Valid @RequestBody User user)
	{
		
		HttpStatus status = HttpStatus.ACCEPTED;
		
		if (!userService.update(user))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(user,status);
	}
	
	@DeleteMapping ("/delete/{uid}")
	public ResponseEntity<String> deleteUser (@PathVariable String uid)
	{
		HttpStatus status = HttpStatus.OK;
		
		if (!userService.delete(uid))
			status = HttpStatus.NOT_FOUND;
		
		
		return new ResponseEntity<>(uid,status); 
		
	}
	
	@GetMapping ("/consultbyusername")
	public ResponseEntity<List<User>> obtenerClientesPorNombre (@RequestParam String username)
	{
		ResponseEntity<List<User>> response;
		List<User> users;
		
		System.out.println("recibido " + username);
		
		users = userService.findByUsername(username);
		
		
		response = new ResponseEntity<>(users,HttpStatus.OK);
		
		
		return response;
	}
	
}
