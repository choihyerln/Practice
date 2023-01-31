package com.mulcam.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.sample.entity.Song;
import com.mulcam.sample.service.SongService;

@Controller
@RequestMapping("/song")
public class SongController {
	
	@Autowired private SongService songService;
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "<h1>Hello world!!!</h1>";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Song> list = songService.getSongList();
		model.addAttribute("songList", list);
		return "song/list";
	}

}
