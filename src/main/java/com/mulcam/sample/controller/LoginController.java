package com.mulcam.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class LoginController {

	@GetMapping("/login")
	public String loginForm() {
		return "user/login";
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "user/join";
	}
	
}
