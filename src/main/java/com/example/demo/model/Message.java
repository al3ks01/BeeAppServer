package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Message implements Serializable {

	@Id
	private String msgId;
	
	private String senderId;
	
	private String receiverId;
	
	private String body;
}
