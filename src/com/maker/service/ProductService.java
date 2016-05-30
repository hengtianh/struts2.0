package com.maker.service;

import java.util.List;

import com.maker.entity.CartItem;
import com.maker.entity.Page;
import com.maker.entity.Product;

public interface ProductService {
	
	/**
	 * 
	 * @param p Ҫ��ӵ���Ʒ
	 * @return
	 */
	public boolean addPro(Product p);
	
	/**
	 * 
	 * @param p Ҫ�޸ĵ���Ʒ
	 * @return
	 */
	public boolean update(Product p);
	
	/**
	 * 
	 * @return ���ҵ������ָߵ�����Ʒ
	 */
	public List findGood();
	
	/**
	 * 
	 * @param cateid ����ĳ�������Ʒ
	 * @return
	 */
	public Page findByid(int cateid , int currentPage);
	
	
	/**
	 * 
	 * @param proname ��Ʒ����
	 * @return
	 */
	public List findByProName(String proname);
	
	/**
	 * 
	 * @param cateid ��Ʒ����id
	 * @return ������Ʒ������
	 */
	public int getRecord(int cateid);
	
	/**
	 * 
	 * @param productid ��Ʒ��id
	 * @param amount ��Ʒ������
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean add2cart(CartItem i);

	/**
	 * 
	 * @param userid �̼ҵ�id
	 * @return ��Ʒ�б�
	 */
	public List getByuserid(int userid);
	public void delete(CartItem item);
}
