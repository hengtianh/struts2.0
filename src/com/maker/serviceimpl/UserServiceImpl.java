package com.maker.serviceimpl;

import com.maker.dao.UserDao;
import com.maker.daoimpl.UserDaoImpl;
import com.maker.entity.User;
import com.maker.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl();
	
	@Override
	public boolean register(User user) {

		//先判断stuid是否该用户已存在，存在返回，不存在则注册
		boolean result = false;
		if(!dao.getByStuID(user.getStuID())) {
			result = dao.add(user);
		}
		return result;
	}

	@Override
	public User login(String stuID, String password, boolean isBoss) {
		return dao.findByID(stuID, password, isBoss);
	}

	@Override
	public boolean uplevel(String stuID) {
		return dao.update(stuID);
	}

}
