package com.maker.entity;

public class Type {
	private int typeid;
	private String typename;
	
	public Type(){}
	public Type(int typeid, String typename) {
		super();
		this.typeid = typeid;
		this.typename = typename;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
