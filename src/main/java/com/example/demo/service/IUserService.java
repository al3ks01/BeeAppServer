package com.example.demo.service;

import java.util.List;
import java.util.Optional;



import com.example.demo.model.User;


public interface IUserService {

	public boolean insert(User user);

	public boolean update(User user);


	public boolean delete(String id);

	public List<User> findAll();

	
	public Optional<User> findById(String id);
	
	public List<User> searchUsers(String username);

	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByEmail(String email);
	

}
