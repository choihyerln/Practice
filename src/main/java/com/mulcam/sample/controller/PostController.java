package com.mulcam.sample.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mulcam.sample.dto.MemberDTO;

@RestController
@RequestMapping("/postApi")
public class PostController {
	
	@RequestMapping("/hello")
	public String postHello() {
		return "hello~~";
	}
	
	@PostMapping("/name")
	public String postName() {
		return "post 매핑 Hello World!!!";
	}
	
	@PostMapping("/member")
	public String postMember(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map ->{
			sb.append(map.getKey() + ": " + map.getValue() + "\n");
			
		});
		return sb.toString();
	}
	
	@PostMapping("/member2")
	public String postMemberDto(@RequestBody MemberDTO mt) {
		return mt.toString();
	}
}
