package edu.gduf.liu.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtils {

	/*private FreeMarkerUtils() {
	}*/

	/**
	 * 根据模版获得一个指定的模版
	 * 
	 * @param name
	 * @return
	 */
	public Template getTemplate(String name) {
		try {
			// 获得配置对象
			Configuration configuration = new Configuration();
			// 设置模版的文件夹路径，本人在src下新建了一个ftl文件夹
			configuration.setClassForTemplateLoading(this.getClass(), "src/ftl");
			// 更具名字获得指定的一个模版
			Template template = configuration.getTemplate(name);

			return template;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据指定的名字获得指定的模版，传入键值对即：key—value ,key对应ftl文件中$｛key｝
	 * 
	 * @param name
	 * @param root
	 */
	public void print2Console(String name, Map<String, Object> root) {
		try {

			Template template = getTemplate(name);
			// PrintWriter中接收一个输出流，所以写可以传入文件流，输出到一个文
			// 件中
			template.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
