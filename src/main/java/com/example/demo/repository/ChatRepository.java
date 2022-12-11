package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chat;
import com.example.demo.model.Message;

@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {


	//@Query(value="SELECT c.id FROM chat c JOIN chat_users cu on c.id=cu.chat_id AND cu.users = '?1'", nativeQuery = true)
	//@Query(value="SELECT * FROM chat c WHERE c.id=chat_users.chat_id AND chat_users.users = '?1'", nativeQuery = true)
	@Query("{$and: [{ 'users': ?0},{'type':'EVENT'}")
	List<Chat> findAllEventChatsFromUser(String userId);
	
	//@Query(value="SELECT * FROM chat c, chat_users cu WHERE c.chat_id=cu.chat_id AND cu.users = '?1' AND cu.users = '?2'", nativeQuery = true)
	//boolean existsByUsersIds(String user1Id, String user2Id);
	
	//List<Message> findByChatId(String chatId);
	

	@Query("{$and: [{'type':'PRIVATE'},{ 'users': ?0},{ 'users': ?1}]}")
	Optional<Chat> findChatByParticipants(String id1, String id2);
}
