package com.mulcam.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mulcam.sample.dto.MemberDTO;

@RestController
@RequestMapping("/getApi")
public class GetController {
	
	@RequestMapping("/hello")
	public String getHello() {
		return "get 매핑 Hello 입니다!";
	}
	
	@GetMapping("/name")
	public String getName() {
		return "getName 입니다! Hyerin";
	}
	
	@GetMapping("/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		return variable;
	}
	
	@GetMapping("/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var) {
		return var;
	}
	
	@GetMapping("/request1")
	public String getRequestParam1(
		@RequestParam String name,
		@RequestParam String email,
		@RequestParam String organization) {
		return name + " " + email + " " + organization;
	}
	
	@GetMapping("/request3")
	public String getRequestParam2(MemberDTO memberDTO) {
		return memberDTO.toString();
	}

}
