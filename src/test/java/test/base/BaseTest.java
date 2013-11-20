package test.base;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(OrderedRunner.class)
@WebAppConfiguration
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/cfg/spring-servlet.xml" })
@ContextConfiguration(locations = { "classpath:spring-datasource.xml","classpath:spring-servlet.xml"})
public class BaseTest {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected WebApplicationContext wac;
	@Autowired
	protected MockHttpSession session;
	@Autowired
	protected MockHttpServletRequest request;

	/*
	 * @Autowired protected ApplicationContext ac;
	 */

	protected MockMvc mockMvc;

	@Before
	public void setup() {
		// webAppContextSetup 注意上面的static import
		// webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS
		// WebApplicationContext context =
		// ContextLoader.getCurrentWebApplicationContext();
		// 如果控制器包含如上方法 则会报空指针
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
		logger.info(mockMvc);
	}

}