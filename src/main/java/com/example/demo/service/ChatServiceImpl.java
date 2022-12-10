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

		if (daoChat.existsById(chat.getId())) {
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

	//Encontrar 1 chat por id de chat
	@Override
	public Optional<Chat> findById(String id) {

		return daoChat.findById(id);
	}

	//Encontrar todos los chats de un user por id del user
	@Override
	public List<Chat> findAllEventChatsFromUser(String userId) {

		
		List<Chat> chats = daoChat.findAllEventChatsFromUser(userId);
		
		System.out.println("chats desde Service: "+chats);
		
		return chats;
	}
	
	//Encontrar 1 chat entre 2 usuarios por el id de ambos
	public  Optional<Chat> findChat(String id1, String id2){
		
		return daoChat.findChatByParticipants(id1, id2);
		
	}
	

}
