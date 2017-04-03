package com.iquest.services;

import java.util.Set;

import com.iquest.models.CourseModel;
import com.iquest.models.UserModel;

public interface UserService {

	public void createUser(UserModel user, String token);

	public boolean verify(String userToken);

	public long getUserId();

	public UserModel findById(long id);

	public String getUsername();

	public Set<CourseModel> getOwnedCourses();

}
