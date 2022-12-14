package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Chat;


public interface IChatService {

	
	public boolean insert(Chat chat);

	public boolean update(Chat chat);

	public boolean delete(String id);

	public List<Chat> findAll();

	public Optional<Chat> findById(String id);

	public List<Chat> findAllEventChatsFromUser(String userId);
	
	public  Optional<Chat> findChat(String id1, String id2);
}
