package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;

public class MessageServiceimpl implements IMessageService {

	
	@Autowired MessageRepository daoMsg;
	
	@Override
	public boolean insert(Message message) {
		
		boolean exito = false;

		daoMsg.save(message);
		exito = true;

		return exito;
		
		
	}

	@Override
	public boolean update(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByChatId(String id) {

	
		
		return null;
	}

	@Override
	public Optional<Message> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
