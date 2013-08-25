package test.dao;

import org.junit.Test;

import edu.gduf.liu.dao.CntUserDao;
import test.base.TestBase;

public class TestCntUserDao extends TestBase {
	@Test
	public void testCountAll() {
		CntUserDao cntUserDao = (CntUserDao)wac.getBean(CntUserDao.class);
		System.out.println("userDao"+cntUserDao);
		long beginTime = System.currentTimeMillis();// 1、开始时间
		System.out.println(cntUserDao.countAll());
		long endTime = System.currentTimeMillis();// 2、结束时间
		long consumeTime = endTime - beginTime;// 3、消耗的时间
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime));
	}

	@Test
	public void testgetCntUsers() {
		CntUserDao cntUserDao = (CntUserDao)wac.getBean(CntUserDao.class);
		System.out.println("userDao"+cntUserDao);
		long beginTime = System.currentTimeMillis();// 1、开始时间
		System.out.println(cntUserDao.getCntUsers());
		long endTime = System.currentTimeMillis();// 2、结束时间
		long consumeTime = endTime - beginTime;// 3、消耗的时间
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime));
	}
}
