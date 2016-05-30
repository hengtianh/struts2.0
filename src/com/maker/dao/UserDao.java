package com.maker.dao;

import com.maker.entity.User;

public interface UserDao {
	/**
	 * @param stuID
	 * @return ����ͬ����stuid����false,���򷵻�true
	 */
	public boolean getByStuID(String stuID);
	
	/**
	 * 
	 * @param <User>
	 * @param user
	 * @return ע��ɹ�����true,���򷵻�false
	 */
	public boolean add(User user);
	
	/**
	 * 
	 * @param stuID
	 * @param password
	 * @param isBoos
	 * @return ��¼�ɹ�����true,ʧ�ܷ���false
	 */
	public User findByID(String stuID, String password, boolean isBoos);
	
	/**
	 * 
	 * @param user
	 * @return ����user����Ϣ���ɹ�����true,ʧ�ܷ���false
	 */
	public boolean update(String stuID);
	
	
	public User getByID(int id);
	
}
