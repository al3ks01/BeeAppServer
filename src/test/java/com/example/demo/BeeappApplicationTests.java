package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

@SpringBootTest
class BeeappApplicationTests {

	@Autowired
	IUserService userDao;

	 //@Test
	void addUserTest() {

		User user = User.builder().username("pizza").email("mail2@gmail.com").build();

		userDao.insert(user);
	}

	//@Test
	void getAllUsersAndDelete() {

		List<User> users = userDao.findAll();
		System.out.println(users);
		for( User user : users) {
			userDao.delete(user.getUid());
		}
	}

}
