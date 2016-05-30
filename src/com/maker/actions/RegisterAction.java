package com.maker.actions;

import com.maker.entity.User;
import com.maker.service.UserService;
import com.maker.serviceimpl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class RegisterAction implements Action {

	UserService service = new UserServiceImpl();
	@Override
	public String execute() throws Exception {
		
		//判断两次的密码是否一致
		if(password.equals(repassword)){
			//使用数据封装user对象
			User user = add2User();
			//使用用户提交的数据调用注册方法
			boolean boo = service.register(user);
			if(boo){
				setWarn("恭喜您注册成功！");
				return "tips";
			}else{
				setWarn("抱歉，注册未完成，请重试！");
				return "tips";
			}
		}else{
			setWarn("两次输入的密码不一致，请重新输入");
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
