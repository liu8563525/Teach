package test.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.commons.JakartaCommonsLoggingImpl;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import edu.gduf.liu.entity.CntUser;
import edu.gduf.liu.mapper.CntUserMapper;

public class TestCntUserMapper {

	@Test
	public void testCountAll() {
		ApplicationContext aContext = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/spring-servlet.xml");
		CntUserMapper cntUserMapper = (CntUserMapper) aContext.getBean(CntUserMapper.class);
		System.out.println(cntUserMapper.countAll());
	}

	@Test
	public void testGetCntUser() {
		ApplicationContext aContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-servlet.xml");
		CntUserMapper cntUserMapper = aContext.getBean(CntUserMapper.class);
		CntUser cntUser = new CntUser();
		cntUser.setDoc_status("active");
		//cntUser.setDomain_id("EG");
		List<CntUser> cntList=cntUserMapper.getCntUser(cntUser);
		System.out.println(cntList.size());
		cntUser=null;
	}

	  @Test
	  public void shouldUseCommonsLogging() {
	    LogFactory.useCommonsLogging();
	    Log log = LogFactory.getLog(Object.class);
	    //logSomething(log);
	    assertEquals(log.getClass().getName(), JakartaCommonsLoggingImpl.class.getName());
	  }

	  @Test
	  public void shouldUseLog4J() {
	    LogFactory.useLog4JLogging();
	    Log log = LogFactory.getLog(Object.class);
	    testGetCntUser();
	    //logSomething(log);
	    assertEquals(log.getClass().getName(), Log4jImpl.class.getName());
	  }

}
