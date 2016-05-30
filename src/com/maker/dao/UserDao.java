package com.maker.dao;

import com.maker.entity.User;

public interface UserDao {
	/**
	 * @param stuID
	 * @return 存在同名的stuid返回false,否则返回true
	 */
	public boolean getByStuID(String stuID);
	
	/**
	 * 
	 * @param <User>
	 * @param user
	 * @return 注册成功返回true,否则返回false
	 */
	public boolean add(User user);
	
	/**
	 * 
	 * @param stuID
	 * @param password
	 * @param isBoos
	 * @return 登录成功返回true,失败返回false
	 */
	public User findByID(String stuID, String password, boolean isBoos);
	
	/**
	 * 
	 * @param user
	 * @return 更新user的信息，成功返回true,失败返回false
	 */
	public boolean update(String stuID);
	
	
	public User getByID(int id);
	
}
