package com.example.demo.service;

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

		// if (!daoUser.existsById(user.getUid())) {
		daoUser.save(user);
		exito = true;
		// }

		return exito;
	}

	@Override
	public boolean update(User user) {
		boolean exito = false;

		// if (daoUser.existsById(user.getUid())) {
		daoUser.save(user);
		exito = true;
		// }

		return exito;
	}

	//Probablemente haya que cambiar el tipo de UID
	@Override
	public boolean delete(Integer id) {
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
	public Optional<User> findById(Integer id) {

		return daoUser.findById(id);
	}

	@Override
	public List<User> findByUsername(String username) {

		return daoUser.findByUsername(username);
	}

}
