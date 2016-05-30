package com.maker.dao;

import java.util.List;

import com.maker.entity.Page;
import com.maker.entity.Product;

public interface ProductDao {

	/**
	 * 
	 * @param p ��Ʒ����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean add(Product p);
	
	/**
	 * 
	 * @param p ��Ʒ����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean update(Product p);
	
	/**
	 * 
	 * @param productname ��Ʒ������
	 * @return ĳָ����Ʒ���Ƶ��б�
	 */
	public List findSome(String productname);
	
	/**
	 * 
	 * @param typeid ĳָ����Ʒ��ld
	 * @return ָ����Ʒ�Ķ��󼯺ϵ��б�
	 */
	public List findByid(int cateid ,Page page);
	
	/**
	 * 
	 * @return �����Ʒ��������ߵ���Ʒ�����б�
	 */
	public List findBest();
	
	/**
	 * 
	 * @param productid ��Ʒ��id
	 * @return ָ����Ʒ����id����Ʒ����
	 */
	public int getRecord(int cateid);
	
	/**
	 * 
	 * @param userid ������Ʒ���û�id
	 * @return ��Ʒ�б�
	 */
	public List getByUserId(int userid);
}
