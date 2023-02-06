package com.mulcam.sample.service;

import javax.annotation.Resource;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.sample.dao.UserDao;
import com.mulcam.sample.entity.User;
import com.mulcam.sample.session.UserSession;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired private UserDao userDao;
	
	@Resource
	private UserSession userSession;

	@Override
	public User get(String uid) {
		User user = userDao.get(uid);
		return user;
	}

	@Override
	public void register(User u) {
		String cryptedPwd = BCrypt.hashpw(u.getPwd(), BCrypt.gensalt()); 
		u.setPwd(cryptedPwd);
		userDao.insert(u);
	}

	@Override
	public void update(User u) {
		userDao.update(u);
	}
	
	@Override
	public void delete(String uid) {
		userDao.delete(uid);
	}
	
	/** 로그인 */
	@Override
	public int login(String uid, String pwd) {
		User u = userDao.get(uid);
		if (u.getUid() != null) {		// uid 가 존재
			if (BCrypt.checkpw(pwd, u.getPwd())) {
				userSession.setUid(u.getUid());
				userSession.setUname(u.getUname());
				return UserService.CORRECT_LOGIN;
			} else {
				return UserService.WRONG_PASSWORD;
			}
		} 		// uid 가 없음
		return UserService.UID_NOT_EXIST;
	}
}
