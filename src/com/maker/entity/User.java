package com.maker.entity;

public class User {
	/*id int auto_increment primary key not null,
	username varchar(50) not null,
	password varchar(20) not null,
	sex varchar(10) not null,
	stuID varchar(12) not null,
	address varchar(50) not null,
	phone varchar(11) not null,
	isBoss bit not null,
	email varchar(50) not null*/
	private int id;
	private String username;
	private String password;
	private String sex;
	private String stuID;
	private String address;
	private String phone;
	private boolean isBoss;
	private String email;
	
	public User(){}
	public User(String username, String password, String sex, String stuID,
			String address, String phone, boolean isBoss, String email) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.stuID = stuID;
		this.address = address;
		this.phone = phone;
		this.isBoss = isBoss;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
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
	public boolean isBoss() {
		return isBoss;
	}
	public void setBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
