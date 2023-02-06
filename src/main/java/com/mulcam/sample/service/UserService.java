package com.mulcam.sample.service;

import com.mulcam.sample.entity.User;

public interface UserService {
	public static final int CORRECT_LOGIN = 0;
	public static final int WRONG_PASSWORD = 1;
	public static final int UID_NOT_EXIST = 2;

	User get(String uid);

	void register(User u);

	void update(User user);

	void delete(String uid);

	int login(String uid, String pwd);
	
}
