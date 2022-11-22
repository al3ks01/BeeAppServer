package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Message;

public interface MessageRepository extends CrudRepository<Message, String> {

	
	@Query(value="SELECT * FROM message m WHERE m.msg_id = chat_messages.messages AND chat_messages.chat_id= '?1'",nativeQuery = true)
	List<Message> findAllByChatId(String id);
}
