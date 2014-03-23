package com.kevin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kevin.utils.SpringContextHolder;

public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {
	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>(
			"StopWatch-StartTime");
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*//1、请求到登录页面 放行
	    if(request.getServletPath().startsWith(loginUrl)) {
	        return true;
	    }

	    //2、TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求

	    //3、如果用户已经登录 放行
	    if(request.getSession().getAttribute("username") != null) {
	        //更好的实现方式的使用cookie
	        return true;
	    }

	    //4、非法请求 即这些请求需要登录后才能访问
	    //重定向到登录页面
	    response.sendRedirect(request.getContextPath() + loginUrl);
	    return false;*/
		long beginTime = System.currentTimeMillis();// 1、开始时间
		startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见
		logger.info("StopWatchHandlerInterceptor.preHandle()-----");
		System.out.println("注入request" + request);
		System.out.println("注入" + request.getSession().getId());
		HandlerMethod handler2 = (HandlerMethod) handler;
		return true;// 继续流程
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long endTime = System.currentTimeMillis();// 2、结束时间
		long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
		long consumeTime = endTime - beginTime;// 3、消耗的时间
		/*if (consumeTime > 500) {// 此处认为处理时间超过500毫秒的请求为慢请求
			// TODO 记录到日志文件
			System.out.println(String.format("%s consume %d millis",
					request.getRequestURI(), consumeTime));
		}*/
		System.out.println(String.format("%s consume %d millis",
				request.getRequestURI(), consumeTime));
		//logger.info(SpringContextHolder.getBean("freemarkerController"));
		logger.info("StopWatchHandlerInterceptor.afterCompletion()-----");
	}
}
