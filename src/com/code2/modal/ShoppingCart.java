package com.code2.modal;

import java.util.List;

public class ShoppingCart {
	
	private List<CartItem> cartItems;
	private double total;
	
	public ShoppingCart(List<CartItem> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public ShoppingCart(List<CartItem> cartItems, double total) {
		super();
		this.cartItems = cartItems;
		this.total = total;
	}
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
