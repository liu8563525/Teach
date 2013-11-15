package com.kevin.entity;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String password;
	private String type;

	/**
	 * 权限字段
	 * 每一位表示一种权限
	 */
	private String rightContent="0101000000";

	public User(int id, String name, String password, String type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public User(){

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

	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type=type;
	}

	@Override
	public String toString() {
		return "id:"+id+",name:"+name+",password:"+password+",type:"+type;
	}

	public String getRightContent() {
		return rightContent;
	}

	public void setRightContent(String rightContent) {
		this.rightContent = rightContent;
	}

}