package com.worker.Services;

import java.util.List;

import com.worker.Payload.UserDao;

public interface UserService {

	
	UserDao createUser(UserDao userdao);
	UserDao  updateUser(UserDao userdao,long Id);
	UserDao  getUserById(long Id);
	List<UserDao> getAllUser();
	void deleteUser(long Id);
	
}
