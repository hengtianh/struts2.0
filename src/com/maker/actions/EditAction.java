package com.maker.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.maker.entity.Product;
import com.maker.service.ProductService;
import com.maker.serviceimpl.ProductServiceImpl;

public class EditAction {
	private ProductService service = new ProductServiceImpl();
	public String execute() throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Product p = new Product();
		p.setId(id);
		p.setProductID(productid);
		p.setProductname(productname);
		p.setPrice(price);
		p.setNumber(number);
		p.setDescription(description);
		if(service.update(p)){
			return "onsell";
		}
		
		return null;
	}
	private int productid;
	private int id;
	private String productname;
	private double price;
	private int number;
	private String description;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
