package com.example.demo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Chat;
import com.example.demo.model.Message;
import com.example.demo.service.IChatService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WebSocketController {
    
	
    private final SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
	IChatService chatService;

    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

   
     
   
     
    //Los usuarios se suscriben al endpoint del grupo al que pertenezcan y cada vez que se envien mensajes a este endpoint
    //todos los clientes que esten suscritos recibiran el mensaje
   /* @MessageMapping("/group/{groupID}")
    public void group(@DestinationVariable int groupID, Message message) {
        log.info("Receive group message: [" + groupID + " -> " + message.getSenderId() + "]");
        Response response = new Response("Welcome to group " + groupID + ", " + message.getSenderId() + "!");
        simpMessagingTemplate.convertAndSend("/g/" + groupID, response);
    }*/

   
  
    //Una vez que el usuario se haya suscrito a su propio endpoint {/user/<userId>/msg} recibe mensajes a ese endpoint 
    public void chat(@DestinationVariable String chatID,Message message	) {
        log.info("Recibido mensaje privado: [" + message.getSenderId() + " -> " + message.getReceiverId() + ", " + message.getBody() + "]");
        //Response response = new Response("Receive message from user " + message.getSenderId() + ": " + message.getBody());
        
        Chat chat = chatService.findById(chatID).get();
        
        //Chat updateChat = new Chat(chat);
        chat.addMessage(message);
        
        chatService.update(chat);
        
        
        simpMessagingTemplate.convertAndSendToUser(String.valueOf(message.getSenderId()), "/msg", message);
        simpMessagingTemplate.convertAndSendToUser(String.valueOf(message.getReceiverId()), "/msg", message);
    }
}