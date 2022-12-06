package com.example.demo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.demo.model.Message;

public class WebSocketEventListener {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class); 
	//@Autowired private SimpMessageSendingOperations sendingOperations;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		LOGGER.info("new connection");
	}
	
	@EventListener
	public void handleWebSocketDisonnectListener(SessionDisconnectEvent event) {
		
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String userId = (String) headerAccessor.getSessionAttributes().get("userId");
		
		LOGGER.info("Disconnected user: "+userId);
	}
	
}
