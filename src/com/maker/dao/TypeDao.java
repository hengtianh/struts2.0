package com.maker.dao;

import java.util.List;

import com.maker.entity.Category;
import com.maker.entity.Type;

public interface TypeDao {
	
	/**
	 * 
	 * @param type类型对象
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addType(Type type);

	/**
	 * 
	 * @return 所有的type对象的列表
	 */
	public List getAll();
	
	/**
	 * 
	 * @param cg分类对象
	 * @return 添加成功返回true，失败返回false
	 */
	public boolean addCate(Category cg);
	
	/**
	 * 
	 * @return 所有的分类对象
	 */
	public List getAllCate();
}
