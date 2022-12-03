package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

	
	//@Query(value="SELECT * FROM message m WHERE m.msg_id = chat_messages.messages AND chat_messages.chat_id= '?1'",nativeQuery = true)
	//TODO @Query("{users:?1}")
	//List<Message> findAllByChatId(String id);
}
