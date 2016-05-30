package com.maker.dao;

import com.maker.entity.Product;


public interface OrderDao {
	public boolean createOrder(int number,int pid);
	public Product getNum(int productid);
	public boolean comment(int id);

}
