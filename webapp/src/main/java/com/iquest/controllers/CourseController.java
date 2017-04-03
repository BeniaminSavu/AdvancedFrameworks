package com.iquest.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iquest.data.CourseData;
import com.iquest.exceptions.NoCoursesFoundUnderTypeException;
import com.iquest.models.CourseModel;
import com.iquest.services.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/course")
	public String getProductById(@RequestParam("id") long courseId, Model model) {
		model.addAttribute("course", courseService.findCourseById(courseId));
		return "course";
	}

	@RequestMapping("/courses")
	public String viewCourses(Model model) {
		model.addAttribute("courses", courseService.findAllCourses());
		return "courses";
	}

	@RequestMapping("/courses/{type}")
	public String viewCoursesByType(Model model, @PathVariable("type") String courseType) {
		List<CourseData> courses = courseService.findCoursesByType(courseType);

		if (courses == null || courses.isEmpty()) {
			throw new NoCoursesFoundUnderTypeException();
		}
		model.addAttribute("courses", courses);
		return "courses";
	}

	@RequestMapping(value = "courses/add", method = RequestMethod.GET)
	public String getNewCourseForm(Model model) {
		CourseModel newCourse = new CourseModel();
		model.addAttribute("newCourse", newCourse);
		return "addCourse";
	}

	@RequestMapping(value = "courses/add", method = RequestMethod.POST)
	public String processNewCourseForm(@Valid @ModelAttribute("newCourse") CourseModel newCourse, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addCourse";
		}
		courseService.addCourse(newCourse);
		return "redirect:/courses";
	}

}
