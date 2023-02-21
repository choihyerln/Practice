package com.mulcam.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.sample.entity.User;
import com.mulcam.sample.service.UserServiceHyerin;
import com.mulcam.sample.session.UserSession;


@Controller
@RequestMapping("/user")
public class UserController {

	@Resource private UserSession userSession;

	@Autowired private UserServiceHyerin userService;
	
	@GetMapping("/join")
	public String joinForm() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(HttpServletRequest req) {
		String id = req.getParameter("id").strip();
		String pwd = req.getParameter("pwd").strip();
		String pwd2 = req.getParameter("pwd2").strip();
		String nickname = req.getParameter("nickname").strip();
		String email = req.getParameter("email").strip();
		String tel = req.getParameter("tel").strip();
		String strpay = req.getParameter("pay").strip();
		int pay = 0;
		if (strpay != null && !strpay.equals("")) {
			pay = Integer.parseInt(strpay.replace(",", ""));	
			System.out.println(pay);
		}
		String departures = req.getParameter("departures").strip();
		String arrivals = req.getParameter("arrivals").strip();
		String vehicles = req.getParameter("vehicles").strip();
//		if (vehicles == "") {
//			vehicles = null;
//		}
		
		System.out.println(id);
		 
		if (pwd.equals(pwd2)) {
			User u = new User(0L, id, pwd, nickname, email, tel, pay, "", "", vehicles);
//			u.setId(id);
//			u.setPwd(pwd);
//			u.setNickname(nickname);
//			u.setEmail(email);
//			u.setTel(tel);
//			u.setPay(pay);
//			u.setVehicles(vehicles);
			
			userService.join(u);
			System.out.println(u);
			return "redirect:/user/login";
		} else {
			System.out.println("패스워드 입력이 잘못되었습니다.");
			return "redirect:/user/join";
		}
	}
	
	/** 로그인 */
	@GetMapping("/login")
	public String loginForm() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		User u = userService.get(id);
		int result = userService.login(id, pwd);
		switch (result) {
		case UserServiceHyerin.CORRECT_LOGIN:
			return "redirect:/myPage";
			
		case UserServiceHyerin.WRONG_PASSWORD:
			return "user/login";
		
		case UserServiceHyerin.ID_NOT_EXIST:
			return "redirect:/user/join";
		
		default:
			return "";
		}
	}
	
//	@RequestMapping("/logout")
//	public String logout() {
//		userSession.setUid("");
//		userSession.setUname("");
//		return "redirect:/user/login";
//	}
}