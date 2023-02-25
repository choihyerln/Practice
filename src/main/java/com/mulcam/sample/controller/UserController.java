package com.mulcam.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.sample.dto.UserDTO;
import com.mulcam.sample.service.UserService;
import com.mulcam.sample.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired private UserService userService;
	
	/** 회원가입 */
	@GetMapping("/join")
	public String joinForm() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(HttpServletRequest req) {
		String uname = req.getParameter("uname").strip();
		String id = req.getParameter("id").strip();
		String pwd = req.getParameter("pwd").strip();
		String pwd2 = req.getParameter("pwd2").strip();
		String nickname = req.getParameter("nickname").strip();
		String email = req.getParameter("email").strip();
		String tel = req.getParameter("tel").strip();
		String birthDate = req.getParameter("birthDate").strip();
		String addr = req.getParameter("addr").strip();
		String strpay = req.getParameter("pay").strip();
		int pay = 0;
		if (strpay != null && !strpay.equals("")) {
			pay = Integer.parseInt(strpay.replace(",", ""));
		}
		String departures = req.getParameter("departures").strip();
		String arrivals = req.getParameter("arrivals").strip();
		String vehicles = req.getParameter("vehicles").strip();
		 
		if (pwd.equals(pwd2)) {
			User user = new User(0L, uname, id, pwd, nickname, email, tel, birthDate, addr, pay, departures, arrivals, vehicles, 0);
			userService.join(user);
			return "redirect:/user/login";
		} else {
			System.out.println("패스워드 입력이 잘못되었습니다.");
			return "redirect:/user/join";
		}
	}
	
	/** 아이디 중복확인 */
	@PostMapping("/join/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("id") String id) {
		String cnt = userService.idCheck(id);
		System.out.println(cnt);
		return cnt;
	}
	
	/** 닉네임 중복확인 */
	@PostMapping("/join/nicknameCheck")
	@ResponseBody
	public String nicknameCheck(@RequestParam("nickname") String nickname) {
		String c = userService.nicknameCheck(nickname);
		System.out.println(c);
		return c;
	}
	   
	/** 로그인 */
	@GetMapping("/login")
	public String loginForm() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(UserDTO user, HttpSession session, Model model) throws Exception {
		int result = userService.login(user, session);
		
		switch (result) {
		case UserService.CORRECT_LOGIN:
			UserDTO getUser = (UserDTO) session.getAttribute("user");
			model.addAttribute("msg", getUser.getNickname() + "님 환영합니다!");
			model.addAttribute("url", "/mypage/main");
			break;
		case UserService.WRONG_PASSWORD:
			model.addAttribute("msg", "잘못된 비밀번호입니다. 다시 입력해주세요.");
			model.addAttribute("url", "/user/login"); 
			break;
		case UserService.ID_NOT_EXIST:
			model.addAttribute("msg", "존재하지 않는 아이디입니다. 회원 가입 페이지로 이동할게요!");
			model.addAttribute("url", "/user/join");
			break;
		}
			return "user/alertMsg";
	}
	
//	/** 회원정보 수정 */
//	@GetMapping("/update/{uid}")
//	public String updateForm(@PathVariable Long uid, Model model) {
//		UserDTO userDTO = userService.findByUid(uid);
//		model.addAttribute("user", userDTO);
//		return "user/update";
//	}
//	@PostMapping("/update")
//	public String update(HttpServletRequest req) {
//		String nickname = req.getParameter("nickname").strip();
//		String email = req.getParameter("email").strip();
//		String tel = req.getParameter("tel").strip();
//		String birthDate = req.getParameter("birthDate").strip();
//		String addr = req.getParameter("addr").strip();
//		String strpay = req.getParameter("pay").strip();
//		int pay = 0;
//		if (strpay != null && !strpay.equals("")) {
//			pay = Integer.parseInt(strpay.replace(",", ""));
//		}
//		String departures = req.getParameter("departures").strip();
//		String arrivals = req.getParameter("arrivals").strip();
//		String vehicles = req.getParameter("vehicles").strip();
//		User user = new User(nickname, email, tel, birthDate, addr, pay, departures, arrivals, vehicles);
//		userService.update(user);
//		return "redirect:/user/list";
//	}
	
	/** 로그아웃 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/mate/list";
	}
	
	/** 회원탈퇴 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		return "user/delete";
	}
	
	@GetMapping("/deleteConfirm/{id}")
	public String deleteConfirm(@PathVariable String id, HttpSession session) {
		userService.delete(id);
		return "redirect:/mate/list";
	}
}