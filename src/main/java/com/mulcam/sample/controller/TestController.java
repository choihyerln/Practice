package com.mulcam.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.sample.dto.MypageSumDTO;
import com.mulcam.sample.service.CSuccessService;

@Controller
public class TestController {
	@Autowired private CSuccessService css;

	/** MyPage 테스트 */
	@GetMapping("/myPage")
	public String test(Model model) {
		return "myPage/myPage";
	}

	@PostMapping("/myPage")
	@ResponseBody
	public MypageSumDTO get(Model model) {
		MypageSumDTO mypageSumDTO = css.getSum("admin");
		return mypageSumDTO;
	}

}
