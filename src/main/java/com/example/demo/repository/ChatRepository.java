package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chat;

@Repository
public interface ChatRepository extends CrudRepository<Chat, String> {


	@Query(value="SELECT c.id FROM chat c JOIN chat_users cu on c.id=cu.chat_id AND cu.users = '?1'", nativeQuery = true)
	//@Query(value="SELECT * FROM chat c WHERE c.id=chat_users.chat_id AND chat_users.users = '?1'", nativeQuery = true)
	List<String> findAllChatsFromUser(String userId);
	
	//@Query(value="SELECT * FROM chat c, chat_users cu WHERE c.chat_id=cu.chat_id AND cu.users = '?1' AND cu.users = '?2'", nativeQuery = true)
	//Sboolean existsByUsersIds(String user1Id, String user2Id);
}
