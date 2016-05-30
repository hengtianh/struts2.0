package com.maker.service;

import com.maker.entity.Cart;
import com.maker.entity.User;

public interface OrderService {
	public boolean add(User u,Cart c);

	public boolean comment(int id);
}
