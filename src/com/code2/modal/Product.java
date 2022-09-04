package com.code2.modal;

public class Product {
	
	private int id;
	private String name;
	private String imgUrl;
	private Double price;
	
	public Product(String name, String imgUrl, Double price) {
		super();
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
	}
	

	public Product(int id, String name, String imgUrl, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
		
		
}
