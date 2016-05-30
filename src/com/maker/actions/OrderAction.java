package com.maker.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.entity.Cart;
import com.maker.entity.User;
import com.maker.service.OrderService;
import com.maker.serviceimpl.OrderServiceImpl;

public class OrderAction {
	private OrderService service = new OrderServiceImpl();
	public String execute() throws Exception{
		
			HttpSession session = ServletActionContext.getRequest().getSession();
			User u = (User) session.getAttribute(My_Constant.User);
			Cart c = (Cart) session.getAttribute(My_Constant.Cart);
			//System.out.println("进入结算");
			if(service.add(u, c)){
				setCinfo("结算成功！");
				return "tips";
			}else{
				setCinfo("结算未成功！");
				return "tips";
			}
	
		
	}
	private String cinfo;
	
	private int productid;
	public String getCinfo() {
		return cinfo;
	}
	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}

}
