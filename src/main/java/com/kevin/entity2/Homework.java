package com.kevin.entity2;

// Generated 2013-8-9 0:38:56 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Homework generated by hbm2java
 */
public class Homework implements java.io.Serializable {

	private Integer id;
	private String userId;
	private Date uploadTime;
	private String title;
	private String content;
	private String courseId;
	private String annexId;
	private Float score;
	private Integer state;

	public Homework() {
	}

	public Homework(String userId, Date uploadTime, String title, String content) {
		this.userId = userId;
		this.uploadTime = uploadTime;
		this.title = title;
		this.content = content;
	}

	public Homework(String userId, Date uploadTime, String title,
			String content, String courseId, String annexId, Float score,
			Integer state) {
		this.userId = userId;
		this.uploadTime = uploadTime;
		this.title = title;
		this.content = content;
		this.courseId = courseId;
		this.annexId = annexId;
		this.score = score;
		this.state = state;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getAnnexId() {
		return this.annexId;
	}

	public void setAnnexId(String annexId) {
		this.annexId = annexId;
	}

	public Float getScore() {
		return this.score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}