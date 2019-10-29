package com.xsp.stu.entity;

public class User {
	public int id;
	public String su_name;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String su_name) {
		super();
		this.id = id;
		this.su_name = su_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSu_name() {
		return su_name;
	}
	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", su_name=" + su_name + "]";
	}
	
}
