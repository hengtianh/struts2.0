package com.maker.service;

import java.util.List;

import com.maker.entity.Category;

public interface TypeService {

	/**
	 * 
	 * @return
	 */
	public boolean addType();
	
	/**
	 * 
	 * @return 返回type列表
	 */
	public List getType();
	
	/**
	 * 
	 * @return
	 */
	public boolean addCate(Category cg);
	
	/**
	 * 
	 * @return 返回category列表
	 */
	public List getCate();
}
