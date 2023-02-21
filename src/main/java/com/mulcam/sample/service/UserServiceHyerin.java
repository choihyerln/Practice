package com.mulcam.sample.service;

import com.mulcam.sample.entity.User;

public interface UserServiceHyerin {
	public static final int CORRECT_LOGIN = 0;
	public static final int WRONG_PASSWORD = 1;
	public static final int ID_NOT_EXIST = 2;

	User get(String id);

	void join(User u);

	int login(String id, String pwd);
	
//	void delete(String id);
}
