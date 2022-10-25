package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface IUserService {

	public boolean insert(User cliente);

	public boolean update(User cliente);

	public boolean delete(String id);

	public List<User> findAll();

	public Optional<User> findbyUid(String uid);

	public List<User> findByUsername(String username);
	
	// nueva prueba
	//prueba
}
