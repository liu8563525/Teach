package test.mapper;

/*import org.junit.runner.RunWith;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
/*import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;*/

import edu.gduf.liu.mapper.UserMapper;

/*@RunWith(value = SpringJUnit4ClassRunner.class)*/
@Configuration("src/main/webapp/WEB-INF/spring-servlet.xml")
public class TestUserMapper2 {
	
	@Autowired
	UserMapper userMapper;
	
	@Transactional
	public void countAllTest() {
		//ApplicationContext aContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-servlet.xml");
		//UserMapper userMapper = (UserMapper)aContext.getBean(UserMapper.class);
		/*UserMapper userMapper = (UserMapper)aContext.getBean("userMapper");*/
		System.out.println(userMapper.countAll());
	}

	/*@Test
	public void testGetUser() {
		ApplicationContext aContext = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
		UserMapper userMapper = aContext.getBean(UserMapper.class);
		User user = userMapper.getUser("����");
		System.out.println(user.toString());
	}*/

	/*@Test
	public void testAddUser(){
		ApplicationContext aContext = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
		UserMapper userMapper = aContext.getBean(UserMapper.class);
		User user = new User();
		user.setName("����");
		user.setAge(18);
		userMapper.insertUser(user);
		System.out.println("��ӳɹ�");
	}*/
}
