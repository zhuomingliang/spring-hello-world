package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Repository.UserRepository;
import com.example.entry.User;

@Controller
public class WelcomeController {
	@Autowired
	private UserRepository user;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/")
	public String HelloAction() {

		Optional<User> user1 = user.findById(1L);

		if (user1.isPresent()) {
			logger.info(user1.get().getName());
		}

		List<User> users = user.findByName("3333");
		for (User user : users) {
			logger.info(user.getName());
		}

		return "hello";
	}

	@GetMapping("/foobar")
	public String FoobarAction() {
		return "foobar";
	}

	@GetMapping("/ex")
	public String exAction() throws Exception {
		throw new Exception("发生错误");
	}
}