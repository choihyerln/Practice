package com.mulcam.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.sample.entity.CSuccess;
import com.mulcam.sample.service.CSuccessService;

@Controller
@RequestMapping("/challenge")
public class CSuccessController {
	
	@Autowired private CSuccessService css;

	@GetMapping("/list")
	public String list(Model model) {
		List<CSuccess> list = css.getList();
		model.addAttribute("successList", list);
		return "challenge/list";
	}
	
	@GetMapping("/test")
	public String testForm() {
		return "challenge/test";
	}
	
	@PostMapping("/test")
	public String success(CSuccess cs) {
		System.out.println(cs);
		css.insert(cs);
		return "redirect:/challenge/list";
	}
	
}
