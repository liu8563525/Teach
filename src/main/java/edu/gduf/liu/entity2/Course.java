package edu.gduf.liu.entity2;

// Generated 2013-8-9 0:38:56 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Course generated by hbm2java
 */
public class Course implements java.io.Serializable {

	private Integer id;
	private String couName;
	private String couHour;
	private String credit;
	private String teaNum;
	private String detail;
	private Date startTime;
	private String place;

	public Course() {
	}

	public Course(String couName, String teaNum) {
		this.couName = couName;
		this.teaNum = teaNum;
	}

	public Course(String couName, String couHour, String credit, String teaNum,
			String detail, Date startTime, String place) {
		this.couName = couName;
		this.couHour = couHour;
		this.credit = credit;
		this.teaNum = teaNum;
		this.detail = detail;
		this.startTime = startTime;
		this.place = place;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCouName() {
		return this.couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String getCouHour() {
		return this.couHour;
	}

	public void setCouHour(String couHour) {
		this.couHour = couHour;
	}

	public String getCredit() {
		return this.credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTeaNum() {
		return this.teaNum;
	}

	public void setTeaNum(String teaNum) {
		this.teaNum = teaNum;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
