package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chat;
import com.example.demo.model.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
	List<Event> findByName(String name);
	
	@Query("{'attendees':?0}")
	List<Event> findAllEventsFromUser(String userId);
}
