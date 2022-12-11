package com.example.demo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Chat;
import com.example.demo.model.Event;
import com.example.demo.model.Message;
import com.example.demo.service.IChatService;
import com.example.demo.service.IEventService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WebSocketController {
    
	
    private final SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
	IChatService chatService;
    
    @Autowired
	IEventService eventService;

    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

   
     
   
     
    //Los usuarios se suscriben al endpoint del grupo al que pertenezcan y cada vez que se envien mensajes a este endpoint
    //todos los clientes que esten suscritos recibiran el mensaje
    @MessageMapping("/event/{eventID}")
    public void event(@DestinationVariable String eventID, Message message) {
        log.info("Receive group message: [" + eventID + " -> " + message.getSenderId() + "]");
        
        Event event = eventService.findById(eventID).get();
        
        Chat chat = chatService.findById(event.getChatId()).get();
        
        chat.addMessage(message);
        
        chatService.update(chat);
        
        //Response response = new Response("Welcome to group " + groupID + ", " + message.getSenderId() + "!");
        simpMessagingTemplate.convertAndSend("/e/" + eventID, message);
    }

   
  
    //Una vez que el usuario se haya suscrito a su propio endpoint {/user/<userId>/msg} recibe mensajes a ese endpoint
    @MessageMapping("/chat/{chatID}")
    public void chat(@DestinationVariable String chatID, Message message	) {
        log.info("Recibido mensaje privado: [" + message.getSenderId() + " -> " + message.getReceiverId() + ", " + message.getBody() + "]");
        //Response response = new Response("Receive message from user " + message.getSenderId() + ": " + message.getBody());
        
        Chat chat = chatService.findById(chatID).get();
        
        //Chat updateChat = new Chat(chat);
        chat.addMessage(message);
        
        chatService.update(chat);
        
        
        simpMessagingTemplate.convertAndSendToUser(message.getSenderId(), "/msg", message);
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverId(), "/msg", message);
    }
}