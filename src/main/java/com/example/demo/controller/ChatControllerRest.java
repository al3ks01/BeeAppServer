package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Chat;
import com.example.demo.model.User;
import com.example.demo.service.IChatService;

@RestController
@RequestMapping("beeapp/chat")
@CrossOrigin
public class ChatControllerRest {

@Autowired IChatService chatService;
	
	@GetMapping("/consult")
	public ResponseEntity<List<Chat>> getChats(){
		
		return new ResponseEntity<>(chatService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Chat> insertChat(@Valid @RequestBody Chat chat){
		
		System.out.println("Chat recibido " + chat.toString());
		
		HttpStatus status = HttpStatus.CREATED;
		
		
		if (!chatService.insert(chat)) {
			status = HttpStatus.BAD_REQUEST;
		} 
		
		
		return new ResponseEntity<>(chat, status);
	}
	

	@GetMapping("/consult/{id}")
	public ResponseEntity<Chat> getChat(@PathVariable("id") String id){
		
		ResponseEntity<Chat> response;
		Optional<Chat> chat;
		
		chat = chatService.findById(id);
		
		if(chat.isPresent()) {
			response = new ResponseEntity<>(chat.get(), HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		return response;
				
	}
	@PutMapping ("/update")
	public ResponseEntity<Chat> updateChat (@Valid @RequestBody Chat chat)
	{
		System.out.println("Chat recibido: "+chat.toString());
		
		HttpStatus status = HttpStatus.ACCEPTED;
		
		if (!chatService.update(chat))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(chat,status);
	}
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<String> deleteChat (@PathVariable String id)
	{
		HttpStatus status = HttpStatus.OK;
		
		if (!chatService.delete(id))
			status = HttpStatus.NOT_FOUND;
		
		
		return new ResponseEntity<>(id.toString(),status); 
	}
	
	@GetMapping("findallchats/{userid}")
	public ResponseEntity<List<Chat>> findAllChatsFromUser(@PathVariable("userid") String userId){
		
		return new ResponseEntity<>(chatService.findAllChatsFromUser(userId), HttpStatus.OK);
		
	}
	
}