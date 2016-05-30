package com.maker.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.entity.User;
import com.opensymphony.xwork2.Action;

public class LogoutAction implements Action{
	public String execute() throws Exception {
		
		//拿到保存用户的session，若有则移除，若没有则返到错误页面
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute(My_Constant.User);
		if(u!=null){
			session.removeAttribute(My_Constant.User);
			return this.SUCCESS;
		}else{
			this.setTip("您还没有登录！");
			return "tips";
		}
	}

	private String tip;
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getTip(){
		return tip;
	}
}
