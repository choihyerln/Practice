package com.mulcam.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.sample.entity.News;
import com.mulcam.sample.util.NewsUtil;

@Controller
@RequestMapping("/news")
public class NewsController {
    	
	@Autowired private NewsUtil newsUtil;
	
	@GetMapping("/news")
    public String naverNews(Model model) throws Exception {
		List<News> list = new ArrayList<>();
		String[] categories = {"금리", "주택", "주식"};
		for (String category: categories) {
			News n = newsUtil.getNews(category);
			list.add(n);
		}
		
		model.addAttribute(categories[0]);
		System.out.println(categories[0]);
		model.addAttribute("newsList", list);
		
		return "news/news";
    }
}
