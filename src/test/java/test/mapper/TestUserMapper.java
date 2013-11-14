package test.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.kevin.entity.User;
import com.kevin.mapper.UserMapper;

public class TestUserMapper {

	@Test
	public void testCountAll() {
		ApplicationContext aContext = new FileSystemXmlApplicationContext("/src/main/resources/spring-servlet.xml");
		UserMapper userMapper = (UserMapper)aContext.getBean(UserMapper.class);
		/*UserMapper userMapper = (UserMapper)aContext.getBean("userMapper");*/
		/*System.out.println(userMapper.getUser("admin"));*/
		System.out.println(userMapper.countAll());
	}

	@Test
	public void testGetUser() {
		ApplicationContext aContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/cfg/spring-servlet.xml");
		UserMapper userMapper = aContext.getBean(UserMapper.class);
		/*User user = userMapper.getUser("admin","admin");*/
		User user= new User();
		/*user.setName("kevin");
		user.setPassword("liu");*/
		user.setId(1);
		System.out.println(userMapper.getUser(user).size());
		user=null;
	}

	@Test
	public void testAddUser(){
		ApplicationContext aContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/cfg/spring-servlet.xml");
		UserMapper userMapper = aContext.getBean(UserMapper.class);
		User user = new User();
		user.setName("kevin");
		user.setPassword("liu");
		userMapper.insertUser(user);
		System.out.println(user.toString());
	}
}
