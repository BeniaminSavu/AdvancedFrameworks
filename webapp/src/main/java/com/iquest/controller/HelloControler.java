package com.iquest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloControler {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld(ModelMap model) {
		String message = "Hello World!";
		ModelAndView modelAndView = new ModelAndView("helloworld");
		modelAndView.addObject("greeting", message);
		
		return modelAndView;
	}
	
}