package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Chat;
import com.example.demo.repository.ChatRepository;

@Service
public class ChatServiceImpl implements IChatService {

	@Autowired
	private ChatRepository daoChat;

	@Override
	public boolean insert(Chat chat) {

		boolean exito = false;

		daoChat.save(chat);
		exito = true;

		return exito;
	}

	@Override
	public boolean update(Chat chat) {

		boolean exito = false;

		if (daoChat.existsById(chat.getChatId())) {
			daoChat.save(chat);
			exito = true;
		}

		return exito;
	}

	@Override
	public boolean delete(String id) {

		boolean exito = false;

		if (daoChat.existsById(id)) {
			daoChat.deleteById(id);
			exito = true;
		}

		return exito;
	}

	@Override
	public List<Chat> findAll() {

		return (List<Chat>) daoChat.findAll();
	}

	@Override
	public Optional<Chat> findById(String id) {

		return daoChat.findById(id);
	}

	@Override
	public List<Chat> findAllChatsFromUser(String userId) {

		
		return daoChat.findAllChatsFromUser(userId);
	}

}
