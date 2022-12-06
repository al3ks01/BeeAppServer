package com.example.demo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;

//@RestController
//@RequestMapping("/ws")
public class WebSocketController {

	@Autowired ServerWebSocket webSocketProcess;
	
	@PostMapping("/sendMessage")
	public void sendMsgToClient(@RequestParam String userId, @RequestParam Message message) {
		
		webSocketProcess.sendMessage(userId, message);
	}
}
