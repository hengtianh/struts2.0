package com.maker.actions;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.entity.User;
import com.maker.service.UserService;
import com.maker.serviceimpl.UserServiceImpl;

public class UplevelAction {
	UserService service = new UserServiceImpl();
	public String execute() {
	//调用用户的session判断是否为boss,是则返回error页面，不是则调用uplevel方法
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute(My_Constant.User);
		if(u!=null && !u.isBoss()) {
			if(service.uplevel(u.getStuID())){
				this.setInfo("恭喜您升级成功了,您已经是卖家了！");
				return "tips";
			}else{
				this.setInfo("抱歉!升级未完成！");
				return "tips";
			}
		}else{
			this.setInfo("您还未登陆或已经是卖家了，请检查后重试！");
			//System.out.println("设置了提示信息");
			return "tips";
		}
	}
	private String info;
	public void setService(UserService service) {
		this.service = service;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfo(){
		return info;
	}
	
}
