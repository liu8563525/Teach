package com.kevin.entity;

public class CntUser {
	private String id;
	private String doc_status;
	private String domain_id;
	private String user_name;
	private String password;

	public String getDoc_status() {
		return doc_status;
	}
	public void setDoc_status(String doc_status) {
		this.doc_status = doc_status;
	}
	public String getDomain_id() {
		return domain_id;
	}
	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){
		return doc_status+domain_id;
	}
}
