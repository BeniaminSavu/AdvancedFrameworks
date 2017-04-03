package com.iquest.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.iquest.models.UserModel;
import com.iquest.repositories.UserRepository;

public class UsernameValidator implements ConstraintValidator<UniqueIdentifier, String> {

	@Autowired
	private UserRepository userRepository;

	public void initialize(UniqueIdentifier constraintAnnotation) {
	}

	public boolean isValid(String username, ConstraintValidatorContext context) {
		UserModel user;
		try {
			user = userRepository.findByUsername(username);
		} catch (Exception e) {
			return true;
		}
		if (user != null) {
			return false;
		}
		return true;
	}

}
