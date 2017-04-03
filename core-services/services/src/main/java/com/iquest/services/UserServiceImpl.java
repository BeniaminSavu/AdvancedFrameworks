package com.iquest.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.iquest.constants.Token;
import com.iquest.models.CartModel;
import com.iquest.models.CourseModel;
import com.iquest.models.RoleModel;
import com.iquest.models.UserModel;
import com.iquest.models.UserTokenModel;
import com.iquest.repositories.RoleRepository;
import com.iquest.repositories.UserRepository;
import com.iquest.repositories.UserTokenRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository userRoleRepository;

	@Autowired
	private UserTokenRepository userTokenRepository;

	@Autowired
	private CartService cartService;

	public void createUser(UserModel user, String token) {
		RoleModel role = userRoleRepository.findByRoleName("ROLE_USER");
		user.setRole(role);

		UserTokenModel userToken = new UserTokenModel();
		userToken.setToken(token);
		userToken.setDate(new Date());
		userTokenRepository.save(userToken);

		userToken = userTokenRepository.findByToken(token);
		user.setUserToken(userToken);
		userRepository.save(user);
	}

	public boolean verify(String userToken) {
		UserTokenModel token = userTokenRepository.findByToken(userToken);
		boolean hasExpired = false;
		Date currentDate = new Date();
		long timeElapsed = currentDate.getTime() - token.getDate().getTime();
		if (timeElapsed > Token.EXPIRATION_TIME) {
			hasExpired = true;
		}
		return hasExpired;
	}

	public long getUserId() {
		String username = getUsername();
		return userRepository.findByUsername(username).getUserId();
	}

	public UserModel findById(long id) {
		return userRepository.findOne(id);
	}

	public String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	public Set<CourseModel> getOwnedCourses() {
		Set<CourseModel> courses = new HashSet<CourseModel>();
		List<CartModel> carts = cartService.getPurchesedCarts();
		for (CartModel cart : carts) {
			addProducts(courses, cart);
		}
		return courses;
	}

	private void addProducts(Set<CourseModel> courses, CartModel cart) {
		for (CourseModel course : cart.getCourses()) {
			courses.add(course);
		}
	}

}
