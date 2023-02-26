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
	public String join(HttpServletRequest req, Model model) {
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
		String bank = req.getParameter("bank").strip();
		String accountNumber = req.getParameter("accountNumber").strip();
		String code = req.getParameter("code").strip();
		 
		if (pwd.equals(pwd2)) {
			User user = new User(0L, uname, id, pwd, nickname, email, tel, birthDate, addr, pay, departures, arrivals, vehicles, 0, bank, accountNumber, code);
			userService.join(user);
			return "redirect:/user/login";
		} else {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("url", "/user/join");
			return "user/alertMsg";
		}
	}
	
	/** 아이디 중복확인 */
	@PostMapping("/join/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("id") String id) {
		int cnt = userService.idCheck(id);
		return cnt + "";
	}
	
	/** 닉네임 중복확인 */
	@PostMapping("/join/nicknameCheck")
	@ResponseBody
	public String nicknameCheck(@RequestParam("nickname") String nickname) {
		int c = userService.nicknameCheck(nickname);
		return c + "";
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
	
	/** 회원정보 수정 */
	
	//수정하고자 하는 정보를 불러오는 메소드
	@GetMapping("/update/{uid}")
	public String updateForm(@PathVariable Long uid, Model model) {
		UserDTO userDTO = userService.findByUid(uid);
		model.addAttribute("user", userDTO);
		return "user/profile";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest req, Model model) {
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
		String bank = req.getParameter("bank").strip();
		String accountNumber = req.getParameter("accountNumber").strip();
		String code = req.getParameter("code").strip();
		HttpSession session = req.getSession();
		User user;
		
		if (pwd == null || pwd.equals("")) {		// 비밀번호를 입력하지 않은 경우
			user = new User(0L, uname, id, pwd, nickname, email, tel, birthDate, addr, pay, departures, arrivals, vehicles, 0, bank, accountNumber, code);
			userService.update(user, "");

			session.setAttribute("nickname", nickname);
			session.setAttribute("email", email);
			session.setAttribute("tel", tel);
			session.setAttribute("birthDate", birthDate);
			session.setAttribute("addr", addr);
			session.setAttribute("pay", pay);
			session.setAttribute("departures", departures);
			session.setAttribute("arrivals", arrivals);
			session.setAttribute("vehicles", vehicles);
			session.setAttribute("bank", bank);
			session.setAttribute("accountNumber", accountNumber);
			session.setAttribute("code", code);
			return "redirect:/mypage/main";
		}
		 
		else if (pwd.equals(pwd2)) {				// 비밀번호가 올바른 경우
			user = new User(0L, uname, id, pwd, nickname, email, tel, birthDate, addr, pay, departures, arrivals, vehicles, 0, bank, accountNumber, code);
			userService.update(user, pwd);
			
			session.setAttribute("nickname", nickname);
			session.setAttribute("email", email);
			session.setAttribute("tel", tel);
			session.setAttribute("birthDate", birthDate);
			session.setAttribute("addr", addr);
			session.setAttribute("pay", pay);
			session.setAttribute("departures", departures);
			session.setAttribute("arrivals", arrivals);
			session.setAttribute("vehicles", vehicles);
			session.setAttribute("bank", bank);
			session.setAttribute("accountNumber", accountNumber);
			session.setAttribute("code", code);
			return "redirect:/mypage/main";
		} 
		
		else {										// 비밀번호를 잘못 입력한 경우
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("url", "/user/update/{uid}");
			return "user/alertMsg";
		}
	}
	
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