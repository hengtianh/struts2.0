package com.maker.service;

import java.util.List;

import com.maker.entity.CartItem;
import com.maker.entity.Page;
import com.maker.entity.Product;

public interface ProductService {
	
	/**
	 * 
	 * @param p 要添加的物品
	 * @return
	 */
	public boolean addPro(Product p);
	
	/**
	 * 
	 * @param p 要修改的物品
	 * @return
	 */
	public boolean update(Product p);
	
	/**
	 * 
	 * @return 查找到的评分高的勿物品
	 */
	public List findGood();
	
	/**
	 * 
	 * @param cateid 查找某分类的物品
	 * @return
	 */
	public Page findByid(int cateid , int currentPage);
	
	
	/**
	 * 
	 * @param proname 物品名称
	 * @return
	 */
	public List findByProName(String proname);
	
	/**
	 * 
	 * @param cateid 物品分类id
	 * @return 该类物品的总数
	 */
	public int getRecord(int cateid);
	
	/**
	 * 
	 * @param productid 物品的id
	 * @param amount 物品的数量
	 * @return 成功返回true，失败返回false
	 */
	public boolean add2cart(CartItem i);

	/**
	 * 
	 * @param userid 商家的id
	 * @return 物品列表
	 */
	public List getByuserid(int userid);
	public void delete(CartItem item);
}
