package com.maker.dao;

import java.util.List;

import com.maker.entity.Category;
import com.maker.entity.Type;

public interface TypeDao {
	
	/**
	 * 
	 * @param type���Ͷ���
	 * @return ��ӳɹ�����true�����򷵻�false
	 */
	public boolean addType(Type type);

	/**
	 * 
	 * @return ���е�type������б�
	 */
	public List getAll();
	
	/**
	 * 
	 * @param cg�������
	 * @return ��ӳɹ�����true��ʧ�ܷ���false
	 */
	public boolean addCate(Category cg);
	
	/**
	 * 
	 * @return ���еķ������
	 */
	public List getAllCate();
}
