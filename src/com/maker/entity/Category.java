package com.maker.entity;

public class Category {
	private int cateid;
	private int typeid;
	private String catename;
	public Category(){}
	public Category(int cateid, int typeid, String catename) {
		super();
		this.cateid = cateid;
		this.typeid = typeid;
		this.catename = catename;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
}
