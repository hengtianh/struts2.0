package com.maker.actions;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.entity.User;
import com.maker.service.UserService;
import com.maker.serviceimpl.UserServiceImpl;

public class UplevelAction {
	UserService service = new UserServiceImpl();
	public String execute() {
	//�����û���session�ж��Ƿ�Ϊboss,���򷵻�errorҳ�棬���������uplevel����
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute(My_Constant.User);
		if(u!=null && !u.isBoss()) {
			if(service.uplevel(u.getStuID())){
				this.setInfo("��ϲ�������ɹ���,���Ѿ��������ˣ�");
				return "tips";
			}else{
				this.setInfo("��Ǹ!����δ��ɣ�");
				return "tips";
			}
		}else{
			this.setInfo("����δ��½���Ѿ��������ˣ���������ԣ�");
			//System.out.println("��������ʾ��Ϣ");
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
