package com.kevin.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//import org.codehaus.jackson.map.ObjectMapper;

import com.kevin.common.HttpConstants;

public class JSONUtil {

	private final static Logger logger = Logger.getLogger(JSONUtil.class);

	public static String toJSONString(Object o) {
		JSONWriter writer = new JSONWriter();
		writer.writeObject(o);
		return writer.toString();
	}

	public static Object parse(String text) {
		JSONParser parser = new JSONParser(text);
		return parser.parse();
	}

	 //private static final ObjectMapper objectMapper = new ObjectMapper();

	// 将 Java 对象转为 JSON 字符串
	/*public static <T> String toJSON(T obj) {
	String jsonStr;
	try {
	jsonStr = objectMapper.writeValueAsString(obj);
	} catch (Exception e) {
	logger.error("Java 转 JSON 出错！", e);
	throw new RuntimeException(e);
	}
	return jsonStr;
	}*/

	// 将 JSON 字符串转为 Java 对象
	/*public static <T> T fromJSON(String json, Class<T> type) {
	T obj;
	try {
	obj = objectMapper.readValue(json, type);
	} catch (Exception e) {
	logger.error("JSON 转 Java 出错！", e);
	throw new RuntimeException(e);
	}
	return obj;
	}*/

	/**
	 * response直接返回数据到前端
	 * @param data
	 * 输出到前端的数据
	 */
	public void responseWrite(HttpServletResponse response, String data) {
		response.setContentType(HttpConstants.UTF8_JSON_CONTENTTYPE);//text/javascript
		response.setCharacterEncoding(HttpConstants.UTF8_CHARACTERENCODING);
		try {
			PrintWriter out = response.getWriter();
			out.write(data);
			out.flush();
			out.close();
		} catch (IOException exception) {
			logger.warn("response返回json数据出错",exception);
		}
	}
	public void responsePrint(HttpServletResponse response, String data) {
		response.setContentType(HttpConstants.UTF8_JSON_CONTENTTYPE);//text/javascript
		response.setCharacterEncoding(HttpConstants.UTF8_CHARACTERENCODING);
		try {
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();
		} catch (IOException exception) {
			logger.warn("response返回json数据出错", exception);
		}
	}
}
