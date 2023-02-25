package com.mulcam.sample.service;

import javax.servlet.http.HttpSession;

import com.mulcam.sample.dto.UserDTO;
import com.mulcam.sample.entity.User;

public interface UserService {
	public static final int CORRECT_LOGIN = 0;
	public static final int WRONG_PASSWORD = 1;
	public static final int ID_NOT_EXIST = 2;
	
	/** DTO 가져오기 */
	UserDTO findByUid(Long uid);
	UserDTO findById(String id);
	
	/** 로그인 */
	int login(UserDTO user, HttpSession session);
	
	/** 회원가입 */
	void join(User user);

	/** 아이디 중복 검사 */
	int idCheck(String id);

//	/** 회원정보 수정 */
//	void update(User user);

	/** 회원탈퇴 */
	void delete(String id);

}
