package com.iquest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquest.constants.Cart;
import com.iquest.models.CartModel;
import com.iquest.models.UserModel;
import com.iquest.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserService userService;

	public CartModel create(CartModel cart) {
		return cartRepository.save(cart);
	}

	public CartModel getById(long cartId) {
		return cartRepository.findOne(cartId);
	}

	public void update(CartModel cart) {
		cartRepository.save(cart);
	}

	public void delete(long cartId) {
		cartRepository.delete(cartId);
	}

	public CartModel getActiveCart() {
		long userId = userService.getUserId();
		UserModel user = userService.findById(userId);
		List<CartModel> courses = cartRepository.findByUserIdAndApproval(user, Cart.STATUS_UNFINISHED);
		return courses.get(0);
	}

	public List<CartModel> getPurchesedCarts() {
		long userId = userService.getUserId();
		UserModel user = userService.findById(userId);
		return cartRepository.findByUserIdAndApproval(user, Cart.STATUS_FINISHED);
	}

}
