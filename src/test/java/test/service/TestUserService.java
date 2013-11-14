package test.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.kevin.service.UserService;


public class TestUserService {
	/*@Resource
    UserService userService;*/

    @Test
    public void testCountAll(){
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");*/
    	ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-servlet.xml");
    	UserService userService = (UserService)context.getBean("userService");
        System.out.println(userService.countAll());
    }
}