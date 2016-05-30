package com.maker.actions;

import java.util.Iterator;
import java.util.ListIterator;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.entity.Cart;
import com.maker.entity.CartItem;
import com.maker.entity.Product;
import com.maker.service.ProductService;
import com.maker.serviceimpl.ProductServiceImpl;

public class CartAction {
	private ProductService service = new ProductServiceImpl();
	
	public String execute() throws Exception {
		CartItem i =null;
		if(method.equals("create")){
			i  = new CartItem();
			i.setProductid(productid);
			i.setName(name);
			i.setPrice(price);
			i.setAmount(amount);
			i.setAccount();
			if(service.add2cart(i)){
				return "success";
			}else{
				setCtip("添加购物车未成功！");
				return "tips";
			}
		}else {
			Cart c =(Cart) ServletActionContext.getRequest().getSession().getAttribute(My_Constant.Cart);
			synchronized (c) {
				
				Iterator<CartItem> it = c.getItems().listIterator(); 
				//for(CartItem item:c.getItems()){
				while(it.hasNext()){
					CartItem item = it.next();
					if(item.getProductid()==productid){
						it.remove();
						//service.delete(item);
					}
				}
			//}
			}
			return "success";
		}
	}
	private String method;
	private String ctip;
	private int productid;
	private String name;
	private double price;
	private int amount;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCtip() {
		return ctip;
	}
	public void setCtip(String ctip) {
		this.ctip = ctip;
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
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
