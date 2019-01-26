package com.luobo.model;

public class Manager {
	private int id;
	private String name;
	private String password;
	private String title;
	private String contact_infomation;
	public String getContact_infomation() {
		return contact_infomation;
	}
	public void setContact_infomation(String contact_infomation) {
		this.contact_infomation = contact_infomation;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString(){
		return this.name;
	}
}
