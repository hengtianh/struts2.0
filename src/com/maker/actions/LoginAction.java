package com.maker.actions;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.entity.User;
import com.maker.service.UserService;
import com.maker.serviceimpl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class LoginAction implements Action{
	UserService service = new UserServiceImpl();
	public String execute() throws Exception{
		
		//使用提交的参数调用login方法
		User user = service.login(stuID, password, Boss);
		//返回true时添加session数据，返回更新原页面
		if(user!=null){
			//System.out.println("成功了");
			ServletActionContext.getRequest().getSession().setAttribute(My_Constant.User, user);
			return this.SUCCESS;
		}else{
			setNote("您还未注册，或输入的用户名或密码有误");
			return "tips";
		}
	}
	private String note;
	private String stuID;
	private String password;
	private boolean Boss;
	public void setService(UserService service) {
		this.service = service;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNote() {
		return note;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setBoss(boolean boss) {
		this.Boss = boss;
	}
	public boolean getBoss() {
		return Boss;
	}
}
