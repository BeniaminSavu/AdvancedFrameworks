package com.iquest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iquest.authentication.AuthenticationService;
import com.iquest.models.UserModel;

@Controller	
public class SignUpController {

	@Autowired
	private AuthenticationService authenticationService; 
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getNewUserFrom(Model model) {
		UserModel newUser = new UserModel();
		model.addAttribute("newUser", newUser);
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processNewUserFrom(@ModelAttribute("newUser") UserModel newUser, Model model) {
		authenticationService.createUser(newUser);
		model.addAttribute("message", "Thank you for registering. Please confirm your email within 1 day. You may proceed to login");
		return "validation";
	}
	
	@RequestMapping(value = "/signup/validation/{userToken}", method = RequestMethod.GET)
	public String validate(@PathVariable String userToken, Model model) {
		String message = authenticationService.validate(userToken);
		model.addAttribute("message", message);
		return "validation";
	}
}
