package com.example.demo.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.demo.model.Message;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	
	private ConcurrentHashMap<String, WebSocketSession> webSocketSessions = new ConcurrentHashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		webSocketSessions.put(null, session);
	}

	
	protected void handleTextMessage(WebSocketSession session, Message message) throws Exception {
		
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		super.afterConnectionClosed(session, status);
	}



}
