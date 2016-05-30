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
		
		//ʹ���ύ�Ĳ�������login����
		User user = service.login(stuID, password, Boss);
		//����trueʱ���session���ݣ����ظ���ԭҳ��
		if(user!=null){
			//System.out.println("�ɹ���");
			ServletActionContext.getRequest().getSession().setAttribute(My_Constant.User, user);
			return this.SUCCESS;
		}else{
			setNote("����δע�ᣬ��������û�������������");
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
