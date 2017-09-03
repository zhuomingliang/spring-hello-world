package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

        @GetMapping("/")
        public String HelloAction() {
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