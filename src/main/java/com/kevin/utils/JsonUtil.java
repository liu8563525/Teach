package com.kevin.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kevin.common.HttpConstants;

public class JsonUtil {

	final Logger logger = Logger.getLogger(getClass());

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
