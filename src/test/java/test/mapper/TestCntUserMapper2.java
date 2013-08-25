package test.mapper;

import org.junit.Test;

import edu.gduf.liu.mapper.CntUserMapper;
import test.base.TestBase;

public class TestCntUserMapper2 extends TestBase {

	@Test
	public void testCountAll() {
		CntUserMapper cntUserMapper = (CntUserMapper)wac.getBean(CntUserMapper.class);
		System.out.println(cntUserMapper.countAll());
		System.out.println(cntUserMapper.getCntUser("active"));
	}

	@Test
	public void testGetCntUsers2() {
		CntUserMapper cntUserMapper = (CntUserMapper)wac.getBean(CntUserMapper.class);
		long beginTime = System.currentTimeMillis();// 1、开始时间
		System.out.println(cntUserMapper.getCntUsers2().size());
		long endTime = System.currentTimeMillis();// 2、结束时间
		long consumeTime = endTime - beginTime;// 3、消耗的时间
		System.out.println(String.format("cntUserMapper.getCntUsers2() %s consume %d millis",
				request.getRequestURI(), consumeTime));
	}
}
