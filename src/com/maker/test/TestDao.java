package com.maker.test;

import org.junit.Assert;
import org.junit.Test;

import com.maker.dao.UserDao;
import com.maker.daoimpl.UserDaoImpl;
import com.maker.entity.User;

public class TestDao {
	UserDao dao = new UserDaoImpl();
	
	@Test
	public void testadd(){
		User u =new User("Ð¡Ã÷","123","ÄÐ","p131713356","10#1201","18793310254",false,"xiaom@163.com");
		Assert.assertTrue(dao.add(u));
	}
	@Test
	public void testFind(){
		Assert.assertNotNull(dao.findByID("p131713356", "123", false));
	}
	@Test
	public void testGet(){
		Assert.assertTrue(dao.getByStuID("p131713356"));
	}
	@Test
	public void testUP(){
		Assert.assertTrue(dao.update("p131713356"));
	}

}
