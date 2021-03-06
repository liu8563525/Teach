package com.kevin.entity2;

// Generated 2013-8-9 0:38:56 by Hibernate Tools 4.0.0

/**
 * Teacher generated by hbm2java
 */
public class Teacher implements java.io.Serializable {

	private Integer id;
	private String teaName;
	private String teaNum;
	private String sex;
	private String dept;
	private String education;
	private String mobilephone;
	private String email;

	public Teacher() {
	}

	public Teacher(String teaName, String teaNum) {
		this.teaName = teaName;
		this.teaNum = teaNum;
	}

	public Teacher(String teaName, String teaNum, String sex, String dept,
			String education, String mobilephone, String email) {
		this.teaName = teaName;
		this.teaNum = teaNum;
		this.sex = sex;
		this.dept = dept;
		this.education = education;
		this.mobilephone = mobilephone;
		this.email = email;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeaName() {
		return this.teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaNum() {
		return this.teaNum;
	}

	public void setTeaNum(String teaNum) {
		this.teaNum = teaNum;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
