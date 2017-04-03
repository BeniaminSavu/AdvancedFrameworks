package com.iquest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iquest.models.CommentModel;
import com.iquest.models.CourseModel;
import com.iquest.services.CommentService;
import com.iquest.services.CourseService;

@Controller
public class CommentController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "comment/add/{courseId}", method = RequestMethod.POST)
	public String addComment(@PathVariable long courseId, Model model,
			@ModelAttribute("newComment") CommentModel newComment) {
		CourseModel course = courseService.findCourseById(courseId);
		newComment.setCourse(course);
		commentService.create(newComment);
		course = courseService.findCourseById(courseId);
		model.addAttribute("course", course);
		return "course";
	}

	@RequestMapping(value = "comment/add/{courseId}", method = RequestMethod.GET)
	public String getNewCommentForm(Model model, @PathVariable long courseId) {
		CommentModel newComment = new CommentModel();
		model.addAttribute("newComment", newComment);
		return "comment";
	}

}
