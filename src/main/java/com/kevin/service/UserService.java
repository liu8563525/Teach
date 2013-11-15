package com.kevin.service;

import java.util.List;

import com.kevin.entity.CntUser;
import com.kevin.entity.User;
import com.kevin.page.Page;
import com.kevin.utils.HandlerResult;

public interface UserService {
	public int countAll();
	User getUser(User user);
	public List<User> getUsers(Page page);

	public int countCntAll();
	public List<CntUser> getCntUsers(Page page);

	public HandlerResult list();
}
