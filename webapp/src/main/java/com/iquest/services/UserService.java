package com.iquest.services;

import com.iquest.models.UserModel;

public interface UserService {
	
	public void createUser(UserModel user, String token);

	public boolean verify(String userToken);
	
}
