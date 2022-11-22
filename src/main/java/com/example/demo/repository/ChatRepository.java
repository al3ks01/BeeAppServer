package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chat;

@Repository
public interface ChatRepository extends CrudRepository<Chat, String> {

	@Query(value="SELECT * FROM chat c, chat_users cu WHERE c.chat_id=cu.chat_chat_id AND cu.users = '?1'", nativeQuery = true)
	List<Chat> findAllChatsFromUser(String userId);
	
	@Query(value="SELECT * FROM chat c, chat_users cu WHERE c.chat_id=cu.chat_chat_id AND cu.users = '?1' AND cu.users = '?2'", nativeQuery = true)
	boolean existsByUsersIds(String user1Id, String user2Id);
}
