package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.model.Message;

public interface IMessageService {

	
	public boolean insert(Message message);

	public boolean update(Message message);

	public boolean delete(String id);

	public List<Message> findAll();
	
	public List<Message> findByChatId(String id);

	public Optional<Message> findById(String id);

	public List<Message> findByName(String name);
}
