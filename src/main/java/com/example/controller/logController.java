package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class logController {
	@RequestMapping("/indexv")
	private String indexv3() {
		return "/indexv";
		
	}
	@RequestMapping("/login")
	private String login() {
		return "/login";
		
	}
}
