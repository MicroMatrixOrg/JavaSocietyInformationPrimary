package com.luobo.model;

public class Admin {
	private int id ;
	private String name;
	private String password;
	private String createDay;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDay() {
		return createDay;
	}
	public void setCreateDate(String createDay) {
		this.createDay = createDay;
	}
	
}
