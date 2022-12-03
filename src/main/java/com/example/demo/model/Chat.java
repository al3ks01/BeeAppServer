package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Document(value="Chat")
public class Chat implements Serializable{

	@Id
	private String id;
	
	//@ElementCollection
	private Set<String> users;
	
	//@ElementCollection
	private Set<String> messages;
	
}
