package com.luobo.model;

public class Course {
	private int id;
	private String name;
	private int teacher_id;
	private int department_id;
	private int max_user;
	private int selected_man;
	private String date;
	private String info;
	public int getSelected_man() {
		return selected_man;
	}
	public void setSelected_man(int selected_man) {
		this.selected_man = selected_man;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getMax_user() {
		return max_user;
	}
	public void setMax_user(int max_user) {
		this.max_user = max_user;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String toString(){
		return this.name;
	}
}
