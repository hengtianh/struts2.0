package com.maker.service;

import com.maker.entity.User;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return 注册成功返回true，失败返回false
     */
	public boolean register(User user);
	
	/**
	 * 用户登录
	 * @param stuID
	 * @param password
	 * @param isBoss 是否为卖家
	 * @return 登录成功返回true,失败返回false
	 */
	public User login(String stuID,String password,boolean isBoss);
	
	/**
	 * 身份升级
	 * @param stuID
	 * @return 普通用户升级为卖家用户
	 */
	public boolean uplevel(String stuID);
}
