package com.iquest.authentication;

import com.iquest.models.RoleModel;
import com.iquest.models.UserModel;
import com.iquest.repositories.RoleRepository;
import com.iquest.repositories.UserRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private TokenGenerator userTokenGenerator;

	@Autowired
	private EmailSender emailSender;

	public void createUser(UserModel user) {
		String token = userTokenGenerator.generateToken();
		user.setToken(token);
		List<RoleModel> rm = roleRepository.findByRoleName("ROLE_USER");
		System.out.println(rm);
		user.setRoles(rm);
		userRepository.save(user);
		// emailSender.sendMail(user.getEmail(), token);*/
	}

}
