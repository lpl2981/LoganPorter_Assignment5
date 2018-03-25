package com.tech.productmanagement.model;

public class Bids {
	private int id;
	private int productId;
	public Integer getId() {
		return id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	private String userName;
	
	private int price;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return "Bids [userName=" + userName + ", price=" + price + "]";
	}
	public Bids(String userName, int price) {
		super();
		this.userName = userName;
		this.price = price;
	}
	public Bids() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
