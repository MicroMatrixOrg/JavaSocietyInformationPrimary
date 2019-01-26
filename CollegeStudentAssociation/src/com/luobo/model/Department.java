package com.luobo.model;

import java.sql.Timestamp;

public class Department {
	private int id;
	private String name;
	private String info;
	private int masterId;
	private String contact;
	private String createday;
	private Timestamp modificationTime;
	public Timestamp getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(Timestamp modificationTime) {
		this.modificationTime = modificationTime;
	}
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCreateday() {
		return createday;
	}
	public void setCreateday(String createday) {
		this.createday = createday;
	}
	
	public String toString(){
		return this.name;
	}
}
