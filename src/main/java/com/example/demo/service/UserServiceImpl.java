package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository daoUser;

	@Override
	public boolean insert(User user) {
		boolean exito = false;

		if (!daoUser.existsByUsername(user.getUsername()) && !daoUser.existsByEmail(user.getEmail())) {
			daoUser.save(user);
			exito = true;
		}

		return exito;
	}

	@Override
	public boolean update(User user) {
		boolean exito = false;

		
		
		if (daoUser.existsById(user.getId())) {
			daoUser.save(user);
			exito = true;
		}

		return exito;
	}

	// Probablemente haya que cambiar el tipo de UID
	@Override
	public boolean delete(String id) {
		boolean exito = false;

		if (daoUser.existsById(id)) {
			daoUser.deleteById(id);
			exito = true;
		}

		return exito;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) daoUser.findAll();
	}

	// Probablemente haya que cambiar el tipo de UID
	@Override
	public Optional<User> findById(String id) {

		return daoUser.findById(id);
	}

	@Override
	public Optional<User> findByUsername(String username) {

		return daoUser.findByUsername(username);
	}

	@Override
	public Optional<User> findByEmail(String email) {

		return daoUser.findByEmail(email);
	}

	@Override
	public List<User> searchUsers(String username) {
		
		//List<User> users = new ArrayList<User>();
		
		List<User> users = daoUser.findByUsernameContaining(username);
		
		return users;
	}

}
