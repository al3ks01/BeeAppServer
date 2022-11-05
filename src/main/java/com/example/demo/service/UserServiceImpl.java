package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public boolean insert(User cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
