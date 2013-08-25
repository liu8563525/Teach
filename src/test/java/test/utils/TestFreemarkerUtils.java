package test.utils;

import java.util.HashMap;
import java.util.Map;

import edu.gduf.liu.utils.FreeMarkerUtils;

public class TestFreemarkerUtils {

	public static void main(String[] args)
	{
		//上面两个方法写在FreeMakerUtils类中
		FreeMarkerUtils freeMarkerUtils = new FreeMarkerUtils() ;
		Map<String , Object> root = new HashMap<String, Object>();
		root.put("username", "张鸿洋");
		freeMarkerUtils.print2Console("01.ftl", root);
	}

	/*@Test
	public void execute()throws Exception
	{
		ApplicationContext aContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-servlet.xml");
		Configuration cfg =new Configuration();
		cfg.setServletContextForTemplateLoading(aContext.getServletContext(), "WEB-INF/templates");
		Map root =new HashMap();
		root.put("name","Tom");

		Template t = cfg.getTemplate("test.ftl");

		Writer out = aContext.getServletContext().getContext(paramString).getResponse().getWriter();

		t.process(root, out);
	}*/
}
