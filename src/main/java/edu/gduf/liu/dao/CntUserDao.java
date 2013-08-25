package edu.gduf.liu.dao;

import java.util.List;

import edu.gduf.liu.entity.CntUser;
public interface CntUserDao {

	public int countAll();

	public void insertCntUser(CntUser cntUser);

	public List<CntUser> getCntUsers();
}
