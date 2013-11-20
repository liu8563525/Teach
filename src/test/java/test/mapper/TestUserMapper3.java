package test.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.kevin.aop.Order;
import com.kevin.dao.UserDao;
import com.kevin.entity.User;
import com.kevin.mapper.UserMapper;

import test.base.BaseTest;

public class TestUserMapper3 extends BaseTest {
	private Logger logger = Logger.getLogger(getClass());

	@BeforeClass
	@AfterClass
	public static void init() {
		///initSQL("sql/product.sql");
	}

	@Test
	@Order(3)
	public void testCountAll() {
		boolean result=true;
		Assert.assertTrue(result);
		logger.error("testCountAll--oreder(3)");
		UserMapper userMapper = (UserMapper) wac.getBean(UserMapper.class);
		/* UserMapper userMapper = (UserMapper)aContext.getBean("userMapper"); */
		/* System.out.println(userMapper.getUser("admin")); */
		long beginTime = System.currentTimeMillis();// 1、开始时间
		System.out.println(userMapper.countAll());
		long endTime = System.currentTimeMillis();// 2、结束时间
		long consumeTime = endTime - beginTime;// 3、消耗的时间
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime));
	}

	@Test
	@Order(1)
	public void testGetUsers2() throws InterruptedException {
		logger.error("testGetUsers2--oreder(1)");
		UserMapper userMapper = (UserMapper) wac.getBean(UserMapper.class);
		/* UserMapper userMapper = (UserMapper)aContext.getBean("userMapper"); */
		/* System.out.println(userMapper.getUser("admin")); */
		int n = 1;
		long consumeTime = 0;
		for (int i = 0; i < n; i++) {
			long beginTime = System.currentTimeMillis();// 1、开始时间
			System.out.println(userMapper.getUsers2().size());
			long endTime = System.currentTimeMillis();// 2、结束时间
			long consumeTimeTemp = (endTime - beginTime);// 3、消耗的时间
			consumeTime = consumeTime + consumeTimeTemp;
			//Thread.sleep(1000);
		}
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime / n));
	}

	//@Ignore
	@Test
	@Order(2)
	public void testInsertUser() throws InterruptedException {
		logger.error("testInsertUser--oreder(2)");
		UserMapper userMapper = (UserMapper) wac.getBean(UserMapper.class);
		int n = 1;
		long consumeTime = 0;
		for (int i = 0; i < n; i++) {
			long beginTime = System.currentTimeMillis();// 1、开始时间
			User user = new User();
			user.setName("www");
			user.setPassword("123456");
			user.setType("tea");
			userMapper.insertUser(user);
			long endTime = System.currentTimeMillis();// 2、结束时间
			long consumeTimeTemp = (endTime - beginTime);// 3、消耗的时间
			consumeTime = consumeTime + consumeTimeTemp;
			//Thread.sleep(1000);
		}
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime / n));
	}

	//@Test
	public void testInsertBatch() throws InterruptedException {
		logger.error("testInsertUser--oreder(4)");
		UserMapper userMapper = (UserMapper) wac.getBean(UserMapper.class);
		UserDao userDao = (UserDao) wac.getBean(UserDao.class);
		//SqlSessionTemplate sqlSessionTemplate = wac.getBean(SqlSessionTemplate.class);
		//SqlMapClientTemplate sqlMapClientTemplate = wac.getBean(SqlMapClientTemplate.class);
		int n = 1000;
		List<User> userList=new ArrayList<User>();
		for (int i = 0; i < n; i++) {
			User user = new User();
			/*if(i%50==0){
				user.setName(null);
			}else*/
			user.setName("www"+i);
			user.setPassword("123456");
			user.setType("tea");
			userList.add(user);
		}
		long consumeTime = 0;
		long beginTime = System.currentTimeMillis();// 1、开始时间
		userMapper.insertBatch(userList);
		/*final List<User> userListTemp= userList;
		sqlMapClientTemplate.execute(new SqlMapClientCallback() {
	           public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
	               executor.startBatch();
	               int i = 1;
	               for (User user : userListTemp) {
	                   executor.insert("UserMapper.insert", user);
	            	   //executor.insert("insert into user(name,password,type) values(#{name},#{password},#{type})", user);
	                   if (i % 100 == 0) {
	                       // executeBatch会将inBatch置为false
	                       executor.executeBatch();
	                       // 需要再启动一次
	                       executor.startBatch();
	                   }
	                   i++;
	               }
	               executor.executeBatch();
	               return null;
	           }
	       });*/
		//System.out.println(sqlSessionTemplate.getExecutorType());
		long endTime = System.currentTimeMillis();// 2、结束时间
		long consumeTimeTemp = (endTime - beginTime);// 3、消耗的时间
		consumeTime = consumeTime + consumeTimeTemp;
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime));
	}

	//@Test
	/*public void testInsertBatchByTrue() {
		//SqlSessionTemplate sqlSessionTemplate = wac.getBean(SqlSessionTemplate.class);
		// 新获取一个模式为BATCH，自动提交为false的session
		// 如果自动提交设置为true,将无法控制提交的条数，改为最后统一提交，可能导致内存溢出
		//SqlSession session = sqlSessionTemplate.getSqlSessionFactory()
				.openSession(ExecutorType.BATCH, false);
		// 通过新的session获取mapper
		//UserMapper userMapper = session.getMapper(UserMapper.class);
		int size = 1000;
		long consumeTime = 0;
		long beginTime = System.currentTimeMillis();// 1、开始时间
		try {
			for (int i = 0; i < size; i++) {
				User user = new User();
				user.setName("executeBatch"+i);
				user.setPassword("123456");
				user.setType("tea");
				userMapper.insertUser(user);
				if (i % 100 == 0 || i == size - 1) {
					long endTime = System.currentTimeMillis();// 2、结束时间
					long consumeTimeTemp = (endTime - beginTime);// 3、消耗的时间
					consumeTime = consumeTime + consumeTimeTemp;
					// 手动每1000个一提交，提交后无法回滚
					session.commit();
					// 清理缓存，防止溢出
					session.clearCache();
				}
			}
		} catch (Exception e) {
			// 没有提交的数据可以回滚
			session.rollback();
		} finally {
			session.close();
			System.out.println(String.format("%s consume %d millis",
					request.getRequestURI(), consumeTime));
		}
	}*/
}
