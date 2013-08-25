package edu.gduf.liu.service;

import java.util.List;

import edu.gduf.liu.entity.CntUser;
import edu.gduf.liu.entity.User;
import edu.gduf.liu.page.Page;
import edu.gduf.liu.utils.HandlerResult;

public interface UserService {
	public int countAll();
	public List<User> getUsers(Page page);

	public int countCntAll();
	public List<CntUser> getCntUsers(Page page);

	public HandlerResult list();
}
