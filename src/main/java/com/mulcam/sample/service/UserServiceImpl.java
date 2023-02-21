package com.mulcam.sample.service;

import javax.annotation.Resource;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.sample.dao.UserDao;
import com.mulcam.sample.entity.User;
import com.mulcam.sample.session.UserSession;

@Service
public class UserServiceImpl implements UserServiceHyerin {
	
	@Autowired private UserDao userDao;
	
	@Resource private UserSession userSession;

	@Override
	public User get(String id) {
		User user = userDao.get(id);
		return user;
	}

	@Override
	public void join(User u) {
		String cryptedPwd = BCrypt.hashpw(u.getPwd(), BCrypt.gensalt()); 
		u.setPwd(cryptedPwd);
		userDao.insert(u);
	}
	
	/** 로그인 */
	@Override
	public int login(String id, String pwd) {
		System.out.println(id);
		User u = userDao.get(id);
		System.out.println(u);
		if (u.getId() != null) {		// id 가 존재
			if (BCrypt.checkpw(pwd, u.getPwd())) {
				userSession.setId(u.getId());
				userSession.setNickname(u.getNickname());
				return UserServiceHyerin.CORRECT_LOGIN;
			} else {
				return UserServiceHyerin.WRONG_PASSWORD;
			}
		} 		// id 가 없음
		return UserServiceHyerin.ID_NOT_EXIST;
	}
}
