package com.code2.modal;

public class CartItem {
	
	private int productId;
	private String productName;
	private double prodictPrice;
	private int quantity;
	

	public CartItem(int productId, String productName, double prodictPrice, int quantity) {

		this.productName = productName;
		this.prodictPrice = prodictPrice;
		this.quantity = quantity;
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProdictPrice() {
		return prodictPrice;
	}

	public void setProdictPrice(double prodictPrice) {
		this.prodictPrice = prodictPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
