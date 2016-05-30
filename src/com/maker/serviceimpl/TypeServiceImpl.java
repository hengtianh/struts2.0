package com.maker.serviceimpl;

import java.util.List;

import com.maker.dao.TypeDao;
import com.maker.daoimpl.TypeDaoImpl;
import com.maker.entity.Category;
import com.maker.service.TypeService;

public class TypeServiceImpl implements TypeService {

	private TypeDao dao = new TypeDaoImpl();
	@Override
	public boolean addType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getType() {
		// 调用获取type的方法
		
		return dao.getAll();
	}

	@Override
	public boolean addCate(Category cg) {
		
		return dao.addCate(cg);
	}

	@Override
	public List getCate() {
		// 调用获得category的方法
		return dao.getAllCate();
	}

}
