package com.maker.dao;

import java.util.List;

import com.maker.entity.Page;
import com.maker.entity.Product;

public interface ProductDao {

	/**
	 * 
	 * @param p 物品对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean add(Product p);
	
	/**
	 * 
	 * @param p 物品对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean update(Product p);
	
	/**
	 * 
	 * @param productname 商品的名称
	 * @return 某指定商品名称的列表
	 */
	public List findSome(String productname);
	
	/**
	 * 
	 * @param typeid 某指定商品的ld
	 * @return 指定商品的对象集合的列表
	 */
	public List findByid(int cateid ,Page page);
	
	/**
	 * 
	 * @return 获得商品中评分最高的商品对象列表
	 */
	public List findBest();
	
	/**
	 * 
	 * @param productid 产品的id
	 * @return 指定产品类型id的物品数量
	 */
	public int getRecord(int cateid);
	
	/**
	 * 
	 * @param userid 出售商品的用户id
	 * @return 物品列表
	 */
	public List getByUserId(int userid);
}
