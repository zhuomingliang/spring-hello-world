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
	private UserRepository userRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/")
	public String HelloAction() {

		Optional<User> user = userRepository.findById(1L);

		if (user.isPresent()) {
			logger.info(user.get().getName());
		}

		List<User> users = userRepository.findByName("admin");
		for (User u : users) {
			logger.info(u.getName());
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