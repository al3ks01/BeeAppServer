package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

//@Entity
public class User implements Serializable{
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String uid;
	//@NotNull
	private String username;
	//temporal
	private String picture;
	//@NotNull
	private String email;
	//@NotNull 
	private String password;
	
	@Singular
	Set<String> contactUids;
	
	
	
}
