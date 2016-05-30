package com.maker.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.dao.ProductDao;
import com.maker.daoimpl.productDaoImpl;
import com.maker.entity.Cart;
import com.maker.entity.CartItem;
import com.maker.entity.Page;
import com.maker.entity.Product;
import com.maker.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao dao = new productDaoImpl();
	@Override
	public boolean addPro(Product p) {
		// TODO Auto-generated method stub
		return dao.add(p);
	}

	@Override
	public List findGood() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page findByid(int cateid , int currentPage) {
		//分页查找指定分类的物品，实例化page对象
		int record = getRecord(cateid);
		Page p = new Page(currentPage,record,cateid);
		List<Product> list = dao.findByid(cateid , p);
//		System.out.println(list.size());
		p.setList(list);
		return p;
	}

	@Override
	public List findByProName(String proname) {
		// TODO Auto-generated method stub
		return dao.findSome(proname);
	}

	@Override
	public int getRecord(int cateid) {
		return dao.getRecord(cateid);
	}

	@Override
	public boolean add2cart(CartItem i) {
		// 添加购物车的实现
		Cart cart = null; 
		HttpSession session = null;
		session = ServletActionContext.getRequest().getSession();
		cart = (Cart) session.getAttribute(My_Constant.Cart);
		if(cart!=null){
			cart.addItem(i);
			session.setAttribute(My_Constant.Cart, cart);
			//System.out.println("添加购物车成功");
			return true;
		}else{
			cart = new Cart();
			cart.addItem(i);
			session.setAttribute(My_Constant.Cart, cart);
			//System.out.println("添加购物车成功");
			return true;
		}
	}

	@Override
	public void delete(CartItem item) {
		// TODO Auto-generated method stub
		Cart cart = null; 
		HttpSession session = null;
		session = ServletActionContext.getRequest().getSession();
		cart = (Cart) session.getAttribute(My_Constant.Cart);
		cart.deleteItem(item);
	}

	@Override
	public List getByuserid(int userid) {
		// TODO 调用dao层方法
		return dao.getByUserId(userid);
	}

	@Override
	public boolean update(Product p) {
		// TODO Auto-generated method stub
		return dao.update(p);
	}

}
