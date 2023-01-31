package com.mulcam.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.sample.entity.Challenge;
import com.mulcam.sample.service.ChallengeService;

@Controller
@RequestMapping("/challenge")
public class ChallengeController {
	
	@Autowired private ChallengeService cs;
	
	
	@RequestMapping("/choice2")
	public String challenge(Model model) {
		List<String> list = new ArrayList<>();
		list.add("대중교통 이용하기");
		list.add("배달 대신 집밥 먹기");
		list.add("커피값 줄이기");
		model.addAttribute("challenge", list);
		return "challenge/choice2";
	}
	
	@GetMapping("/choice")
	public String listForm(Model model) {
		List<Challenge> list = cs.getChallengeList();
		list.forEach(x -> System.out.println(x));
		model.addAttribute("challenge", list);
		return "challenge/choice";
	}
	
	@GetMapping("/choice/{cid}")
	public String updateForm(@PathVariable int cid, Model model) {
		Challenge c = cs.getChallenge(cid);
		model.addAttribute("c", c);
		System.out.println(c);
		return "challenge/confirm";
	}
	
	@GetMapping("/confirm")
	public String nameList(Model model) {
		List<Challenge> nameList = cs.getChallengeList();
		model.addAttribute("challenge", nameList);
		return "challenge/confirm";
	}
	
	@GetMapping("/tmp/{cid}")
	public String nameList2(Model model) {
		List<Challenge> nameList = cs.getChallengeList();
		model.addAttribute("challenge", nameList);
		return "challenge/confirm";
	}
	
}
