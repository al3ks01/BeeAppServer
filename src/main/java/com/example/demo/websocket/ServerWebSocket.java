package com.example.demo.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.annotation.ApplicationScope;

import com.example.demo.model.Message;

import lombok.extern.slf4j.Slf4j;

@ApplicationScope
@ServerEndpoint(value="/connection/{userId}")
@Slf4j
@Component
public class ServerWebSocket {

	private ConcurrentHashMap<String, ServerWebSocket> concurrentHashMap = new ConcurrentHashMap<>();

	private Session session;

	@OnOpen
	public void onOpen(Session session,@PathParam("userId") String userId) {

		this.session = session;

		log.info("Session opened for user: " + userId);

		concurrentHashMap.put(userId, this);
	}

	@OnMessage
	public void onMessage(Message message, Session session) {

		log.info("session: " + session + "message: " + message);
	}

	@OnClose
	public void onClose(Session session, String userId) {

		System.out.println("Session closed " + session);

		concurrentHashMap.remove(userId);
	}

	@OnError
	public void onError(Session session, Throwable error) {
		log.info("Error in websocket " + error);
	}

	public void sendMessage(String userId, Message message) {

		ServerWebSocket webSocketProcess = concurrentHashMap.get(userId);

		if (!ObjectUtils.isEmpty(webSocketProcess)) {
			if (webSocketProcess.session.isOpen()) {
				try {
					webSocketProcess.session.getBasicRemote().sendObject(message);
				} catch (IOException | EncodeException e) {
					e.printStackTrace();
				}
			}else {
				log.info("Session isnt open");
			}
		}else {
			log.info("Session doesnt exist");
		}

		try {
			session.getBasicRemote().sendObject(message);
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
