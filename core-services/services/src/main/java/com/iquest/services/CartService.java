package com.iquest.services;

import java.util.List;

import com.iquest.models.CartModel;

public interface CartService {

	CartModel create(CartModel cart);

	CartModel getById(long cartId);

	void update(CartModel cart);

	void delete(long cartId);

	CartModel getActiveCart();

	List<CartModel> getPurchesedCarts();

}
