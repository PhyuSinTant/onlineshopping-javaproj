package com.code2.modal;

import java.sql.Timestamp;
import java.time.Instant;

public class Order {
	
	
	private int id;
	private String customerName;
	private double total;
	private Timestamp orderTime;
	private String mobile;
	private String address;
	private boolean deliveried;
	
	public Order(int id, String customerName, double total, Timestamp orderTime, String mobile, String address,boolean deliveried) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.total = total;
		this.orderTime = orderTime;
		this.mobile = mobile;
		this.address = address;
		this.deliveried=deliveried;
	}
	public Order(String customerName, double total, Timestamp orderTime, String mobile, String address,boolean deliveried) {
		super();
		this.customerName = customerName;
		this.total = total;
		this.orderTime = orderTime;
		this.mobile = mobile;
		this.address = address;
		this.deliveried=deliveried;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public boolean isDeliveried() {
		return deliveried;
	}
	public void setDeliveried(boolean deliveried) {
		this.deliveried = deliveried;
	}
	
	

}
