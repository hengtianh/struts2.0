package com.maker.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.service.ProductService;
import com.maker.serviceimpl.ProductServiceImpl;

public class OnsellAction {
	private ProductService service = new ProductServiceImpl();
	public String execute() throws Exception {
		//调用获取到的信息后返回响应页面
		HttpSession session = ServletActionContext.getRequest().getSession();
		List list = service.getByuserid(userid);
		if(list!=null){
			session.setAttribute(My_Constant.Onsell, list);
		}
		return "onsell";
	}

	private int userid;
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
