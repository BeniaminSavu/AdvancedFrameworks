package com.iquest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iquest.models.CourseModel;
import com.iquest.services.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/courses")
	public String viewCourses(Model model) {
		model.addAttribute("courses", courseService.findAllCourses());
		return "courses";
	}

	@RequestMapping(value = "courses/add", method = RequestMethod.GET)
	public String getNewCourseForm(Model model) {
		CourseModel newCourse = new CourseModel();
		model.addAttribute("newCourse", newCourse);
		return "addCourse";
	}

	@RequestMapping(value = "courses/add", method = RequestMethod.POST)
	public String processNewCourseForm(@ModelAttribute("newProduct") CourseModel newProduct) {
		courseService.addCourse(newProduct);
		return "redirect:/courses";
	}
}
