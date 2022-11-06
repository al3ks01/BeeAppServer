package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByUsername(String username);
}
