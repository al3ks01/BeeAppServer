package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Singular;

public class Chat implements Serializable{

	@Id
	private String id;
	
	private String userId1;
	
	
	private String userId2;
	
	@Singular
	@OneToMany
	private List<Message> messages;
	
	
}
