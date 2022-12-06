package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Chat;
import com.example.demo.model.Message;
import com.example.demo.service.IChatService;

//@RestController
public class ChatMessageController {

	@Autowired private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired IChatService chatService;
	
	@MessageMapping("/chat.send")
	@SendTo("chat/public")
	 public Message sendMessage(@Payload Message message) {
		
		
		Chat chat = chatService.findChat(message.getReceiverId(), message.getSenderId()).get();
		
		chat.addMessage(message);
		chatService.update(chat);
		
		 		 
		simpMessagingTemplate.convertAndSendToUser(message.getReceiverId(),"/user",message);
		
		return message;
	 }
	
	
	@MessageMapping("/chat.newUser")
	public Message newUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
		
		headerAccessor.getSessionAttributes().put("userId", message.getSenderId());
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
