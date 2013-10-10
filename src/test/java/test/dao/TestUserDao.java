package test.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.gduf.liu.dao.UserDao;
import edu.gduf.liu.entity.User;
import test.base.TestBase;

public class TestUserDao extends TestBase {
	@Test
	public void testCountAll() {
		UserDao userDao = (UserDao) wac.getBean(UserDao.class);
		System.out.println("userDao" + userDao);
		long beginTime = System.currentTimeMillis();// 1、开始时间
		System.out.println(userDao.countAll());
		long endTime = System.currentTimeMillis();// 2、结束时间
		long consumeTime = endTime - beginTime;// 3、消耗的时间
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime));
	}

	@Test
	public void testGetUsers() throws InterruptedException {
		UserDao userDao = (UserDao) wac.getBean(UserDao.class);
		int n = 10;
		long consumeTime = 0;
		for (int i = 0; i < n; i++) {
			long beginTime = System.currentTimeMillis();// 1、开始时间
			System.out.println(userDao.getUsers().size());
			//System.out.println(userDao.updateUser(5000));
			long endTime = System.currentTimeMillis();// 2、结束时间
			long consumeTimeTemp = (endTime - beginTime);// 3、消耗的时间
			consumeTime = consumeTime + consumeTimeTemp;
			//Thread.sleep(1000);
		}
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime / n));
	}

	@Test
	public void testInsertUser() throws InterruptedException {
		UserDao userDao = (UserDao) wac.getBean(UserDao.class);
		int n = 1000;
		long consumeTime = 0;
		for (int i = 0; i < n; i++) {
			long beginTime = System.currentTimeMillis();// 1、开始时间
			User user = new User();
			user.setName("www");
			user.setPassword("123456");
			user.setType("tea");
			System.out.println(userDao.insertUser(user));
			long endTime = System.currentTimeMillis();// 2、结束时间
			long consumeTimeTemp = (endTime - beginTime);// 3、消耗的时间
			consumeTime = consumeTime + consumeTimeTemp;
			//Thread.sleep(1000);
		}
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime / n));
	}
	@Test
	//@Transactional
	public void testInsertBatch() throws InterruptedException {
		UserDao userDao = (UserDao) wac.getBean(UserDao.class);
		int n = 10000;
		long consumeTime = 0;
		List<User> userList=new ArrayList<User>();
		for (int i = 0; i < n; i++) {
			User user = new User();
			/*if(i%2000==0){
				user.setName(null);
			}else*/
			user.setName("www"+i);
			user.setPassword("123456");
			user.setType("tea");
			userList.add(user);
		}
		long beginTime = System.currentTimeMillis();// 1、开始时间
		System.out.println(userDao.insertBatch(userList));
		//System.out.println(userDao.insertBatchByJdbcTemplate(userList));
		//System.out.println(userDao.insertBatchByHibernate(userList));
		long endTime = System.currentTimeMillis();// 2、结束时间
		consumeTime = (endTime - beginTime);// 3、消耗的时间
		//Thread.sleep(1000);
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime));
	}
}
