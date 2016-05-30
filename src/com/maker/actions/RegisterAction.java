package com.maker.actions;

import com.maker.entity.User;
import com.maker.service.UserService;
import com.maker.serviceimpl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class RegisterAction implements Action {

	UserService service = new UserServiceImpl();
	@Override
	public String execute() throws Exception {
		
		//�ж����ε������Ƿ�һ��
		if(password.equals(repassword)){
			//ʹ�����ݷ�װuser����
			User user = add2User();
			//ʹ���û��ύ�����ݵ���ע�᷽��
			boolean boo = service.register(user);
			if(boo){
				setWarn("��ϲ��ע��ɹ���");
				return "tips";
			}else{
				setWarn("��Ǹ��ע��δ��ɣ������ԣ�");
				return "tips";
			}
		}else{
			setWarn("������������벻һ�£�����������");
			return "tips";
		}
	}
	
	private User add2User(){
		User user = new User();
		user.setUsername(name);
		user.setSex(sex);
		user.setPassword(password);
		user.setSex(sex);
		user.setAddress(address);
		user.setStuID(stuid);
		user.setPhone(phone);
		user.setBoss(boss);
		user.setEmail(email);
		return user;
	}

	private String warn;
	private String name;
	private String sex;
	private String stuid;
	private String password;
	private String repassword;
	private String address;
	private String phone;
	private String email;
	private boolean boss;
	
	public String getWarn() {
		return warn;
	}
	public void setWarn(String warn) {
		this.warn = warn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getBoss() {
		return boss;
	}
	public void setBoss(boolean boss) {
		this.boss = boss;
	}
	
}
