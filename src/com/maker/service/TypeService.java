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
	 * @return ����type�б�
	 */
	public List getType();
	
	/**
	 * 
	 * @return
	 */
	public boolean addCate(Category cg);
	
	/**
	 * 
	 * @return ����category�б�
	 */
	public List getCate();
}
