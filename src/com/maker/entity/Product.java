package com.maker.entity;

public class Product {
	/*productID int auto_increment primary key not null,
	id int not null,
	cateID int not null,
	productname varchar(50) not null,
	price double not null,
	number int not null,
	image varchar(200) not null,
	description varchar(200) not null,
	foreign key (id) references usertbl(id),
	foreign key (cateID) references category(cateID)*/

	private int productID;
	private int id;
	private int cateID;
	private String productname;
	private double price;
	private int number;
	private String image;
	private String description;
	public Product(){}
	public Product(int productID, int id, int cateID, String productname,
			double price, int number, String image, String description) {
		super();
		this.productID = productID;
		this.id = id;
		this.cateID = cateID;
		this.productname = productname;
		this.price = price;
		this.number = number;
		this.image = image;
		this.description = description;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
