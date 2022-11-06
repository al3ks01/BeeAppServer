package com.example.demo.restclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

public class AppRestClient {
	final static String URLBASE = "http://localhost:8080/";
	
	
	
	public static User getUser (String uid)
	{
		String URLSEARCH = URLBASE + "/consult/{uid}";
		User user;
		RestTemplate restTemplate = new RestTemplate();
		
		try
		{
			
			ResponseEntity<User> response  = 
					restTemplate.getForEntity(URLSEARCH, User.class,uid);
			
			user = response.getBody();
			
		}
		catch(HttpClientErrorException e)
		{
			user = null;
		}
		
		return user;
	}
	
	
	public static void insertUser ()
	{
		
		String URLINSERT = URLBASE + "/insert";
		User user;
	
	
		RestTemplate restTemplate = new RestTemplate();
	
		//ReadUser readUser;
		
		boolean valid;
		
		
		
	}
}