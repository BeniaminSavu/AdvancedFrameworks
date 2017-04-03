package com.iquest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iquest.constants.Cart;
import com.iquest.models.CartModel;
import com.iquest.models.CourseModel;
import com.iquest.models.UserModel;
import com.iquest.services.CartService;
import com.iquest.services.CourseService;
import com.iquest.services.UserService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/cart")
	public String cart(Model model) {
		CartModel cart = cartService.getActiveCart();
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@RequestMapping(value = "cart/add/{courseId}")
	public String addItem(@PathVariable long courseId, HttpServletRequest request, Model model) {
		CartModel cart = cartService.getActiveCart();
		if (cart == null) {
			long userId = userService.getUserId();
			UserModel user = userService.findById(userId);
			cart = cartService.create(new CartModel(user));
		}
		CourseModel course = courseService.findCourseById(courseId);
		if (course == null) {
			throw new IllegalArgumentException("course is null");
		}
		cart.addCartItem(course);
		cartService.update(cart);
		model.addAttribute("isCourseAdded","Product added");
		model.addAttribute("course", course);
		return "course";
	}
	
	@RequestMapping(value = "cart/remove/{courseId}")
	public String removeItem(@PathVariable long courseId, HttpServletRequest request, Model model) {
		CartModel cart = cartService.getActiveCart();
		CourseModel course = courseService.findCourseById(courseId);
		if (course == null) {
			throw new IllegalArgumentException("course is null");
		}
		cart.removeCartItem(course);
		cartService.update(cart);
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@RequestMapping(value = "cart/clear")
	public String clearCart(Model model) {
		CartModel cart = cartService.getActiveCart();
		cart.getCourses().clear();
		cart.setGrandTotal(0);
		cartService.update(cart);
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@RequestMapping(value = "cart/checkout")
	public String cartCheckout(Model model) {
		CartModel cart = cartService.getActiveCart();
		cart.setApproval(Cart.STATUS_FINISHED);
		cartService.update(cart);
		long userId = userService.getUserId();
		cart = cartService.create(new CartModel(userService.findById(userId)));
		model.addAttribute("CheckoutMessage", "Thank you for purchasing");
		model.addAttribute("cart", cart);
		return "cart";
	}
	
}
