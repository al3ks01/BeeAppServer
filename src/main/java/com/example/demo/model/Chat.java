package com.example.demo.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Singular;

public class Chat {

	@Id
	private String id;
	
	private String userId1;
	
	
	private String userId2;
	
	@Singular
	@OneToMany
	private List<Message> messages;
	
	
}
