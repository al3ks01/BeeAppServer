package com.example.demo.controller;

import java.util.ArrayList;
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
		
		System.out.println("Usuario recibido " + user.toString());
		
		HttpStatus status = HttpStatus.CREATED;
		
		
		if (!userService.insert(user)) {
			status = HttpStatus.BAD_REQUEST;
		} 
		
		
		return new ResponseEntity<>(user, status);
	}
	
	//Probablemente haya que cambiar el tipo de UID
	@GetMapping("/consult/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id){
		
		ResponseEntity<User> response;
		Optional<User> user;
		
		user = userService.findById(id);
		
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
		System.out.println("Usuario recibido: "+user.toString());
		
		HttpStatus status = HttpStatus.ACCEPTED;
		
		if (!userService.update(user))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(user,status);
	}
	//Probablemente haya que cambiar el tipo de ID
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<String> deleteUser (@PathVariable String id)
	{
		HttpStatus status = HttpStatus.OK;
		
		if (!userService.delete(id))
			status = HttpStatus.NOT_FOUND;
		
		
		return new ResponseEntity<>(id.toString(),status); 
		
	}
	
	@GetMapping ("/consultbyusername")
	public  ResponseEntity<User> getUserByUsername (@RequestParam String username)
	{
		ResponseEntity<User> response;
		Optional<User> user;
		
		System.out.println("recibido " + username);
		
		user = userService.findByUsername(username);
		
		if(user.isPresent()) {
			response = new ResponseEntity<>(user.get(), HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		return response;
	}
	
	@GetMapping("/searchusers")
	public ResponseEntity<List<User>> searchUsers (@RequestParam String username)
	{
		ResponseEntity<List<User>> response;
		
		List<User> users = userService.searchUsers(username);
		System.out.println("ususarios encontrados: "+users.toString());
		
		if(users.isEmpty()) {
			response = new ResponseEntity<>(users,HttpStatus.NOT_FOUND);
		}else {
			response = new ResponseEntity<>(users,HttpStatus.OK);
		}
		
		
		
		return response;
	}
	
	@GetMapping ("/consultbyemail")
	public  ResponseEntity<User> getUserByEmail (@RequestParam String email)
	{
		ResponseEntity<User> response;
		Optional<User> user;
		
		System.out.println("recibido " + email);
		
		user = userService.findByEmail(email);
		
		if(user.isPresent()) {
			response = new ResponseEntity<>(user.get(), HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		return response;
	}
}
