package com.maker.entity;


public class CartItem {
	
	private int productid;
	private String name;
	private double price;
	private int amount = 0;//¹ºÂòµÄÊýÁ¿
	private double account = 0;
		
	public CartItem(){}

	public CartItem(int productid, String name,
			double price, int amount, double account) {
		super();
		this.productid = productid;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.account = account;
	}

	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double pirce) {
		this.price = pirce;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getAccount() {
		return this.account = price*amount;
	}
	public void setAccount() {
		this.account = account;
	}
}
