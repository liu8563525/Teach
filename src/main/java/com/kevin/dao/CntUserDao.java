package com.kevin.dao;

import java.util.List;

import com.kevin.entity.CntUser;
public interface CntUserDao {

	public int countAll();

	public void insertCntUser(CntUser cntUser);

	public List<CntUser> getCntUsers();
}
