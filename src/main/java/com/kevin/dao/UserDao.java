package com.kevin.dao;

import java.util.List;

import com.kevin.entity.User;

public interface UserDao {

	public int countAll();

	public int insertUser(User user);

	public boolean insertBatch(List<User> list);
	public boolean insertBatchByJdbcTemplate(List<User> user);
	public boolean insertBatchByHibernate(List<User> list);

	public int updateUser(int id);

	public User getUser(String name);

	public User getUser(int id);

	public List<User> getUsers();
}
