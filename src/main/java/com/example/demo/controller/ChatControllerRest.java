package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Chat;
import com.example.demo.model.Message;
import com.example.demo.service.IChatService;

@RestController
@RequestMapping("beeapp/chat")
@CrossOrigin
public class ChatControllerRest {

@Autowired IChatService chatService;

@Autowired private SimpMessagingTemplate simpMessagingTemplate;

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
	
	
	 @GetMapping("findallchats")
	public ResponseEntity<List<Chat>> findAllChatsFromUser(@RequestParam("userId") String userId){
		
		List<Chat> chats = chatService.findAllChatsFromUser(userId);
		
		System.out.println("chats: " + chats);
		
		return new ResponseEntity<>(chats, HttpStatus.OK);
		
	}
	 
	 public  ResponseEntity<Chat> findChat(String id1, String id2){
		 
		 ResponseEntity<Chat> response;
			Optional<Chat> chat;
			
			chat = chatService.findChat(id1,id2);
			
			if(chat.isPresent()) {
				response = new ResponseEntity<>(chat.get(), HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
			
			return response;
		 
		 
	 }
	 
	 
	 @MessageMapping("/private-message")
	 public Message receivePrivateMessage(@Payload Message message) {
		 
		simpMessagingTemplate.convertAndSendToUser(message.getReceiverId(),"/private",message);
		
		return message;
	 }
	
	 /*@MessageMapping("/chat")
	    public void processMessage(@Payload Message Message) {
	        var chatId = chatRoomService
	                .getChatId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true);
	        chatMessage.setChatId(chatId.get());

	        ChatMessage saved = chatMessageService.save(chatMessage);
	        
	        messagingTemplate.convertAndSendToUser(
	                chatMessage.getRecipientId(),"/queue/messages",
	                new ChatNotification(
	                        saved.getId(),
	                        saved.getSenderId(),
	                        saved.getSenderName()));
	    }
	}*/
}
