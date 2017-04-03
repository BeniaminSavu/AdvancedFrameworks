package com.iquest.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iquest.models.CourseModel;
import com.iquest.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		Set<CourseModel> courses = userService.getOwnedCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("username", userService.getUsername());
		return "welcome";
	}

}
