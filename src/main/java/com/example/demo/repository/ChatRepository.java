package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chat;

@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {


	//@Query(value="SELECT c.id FROM chat c JOIN chat_users cu on c.id=cu.chat_id AND cu.users = '?1'", nativeQuery = true)
	//@Query(value="SELECT * FROM chat c WHERE c.id=chat_users.chat_id AND chat_users.users = '?1'", nativeQuery = true)
	@Query("{'users':?0}")
	List<Chat> findAllChatsFromUser(String userId);
	
	//@Query(value="SELECT * FROM chat c, chat_users cu WHERE c.chat_id=cu.chat_id AND cu.users = '?1' AND cu.users = '?2'", nativeQuery = true)
	//boolean existsByUsersIds(String user1Id, String user2Id);
}
