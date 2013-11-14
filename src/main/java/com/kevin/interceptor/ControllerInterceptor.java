package com.kevin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 说明：<br>
 * 发起请求,进入拦截器链，运行所有拦截器的preHandle方法，<br>
 * 1.当preHandle方法返回false时，从当前拦截器往回执行所有拦截器的afterCompletion方法，再退出拦截器链。<br>
 * 2.当preHandle方法全为true时，执行下一个拦截器,直到所有拦截器执行完。再运行被拦截的Controller。然后进入拦截器链，
 * 运行所有拦截器的postHandle方法,完后从最后一个拦截器往回执行所有拦截器的afterCompletion方法.<br>
 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有拦截器的afterCompletion方法
 *
 * @author kevin.liu
 *
 */
public class ControllerInterceptor implements HandlerInterceptor {
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	Logger logger = Logger.getLogger(this.getClass());

	/**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse arg1, Object handler) throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatchLocal.set(stopWatch);
		stopWatch.start(handler.toString());
		logger.info("ControllerInterceptor.preHandle()-----");
		return true;
		// return false;
	}

	/**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		logger.info("ControllerInterceptor.postHandle()-----");
	}

	/**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object handler, Exception arg3)
			throws Exception {
		StopWatch stopWatch = stopWatchLocal.get();
		stopWatch.stop();
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		logger.info("access url path:" + currentPath + queryString + " |time:"
				+ stopWatch.getTotalTimeMillis());
		stopWatchLocal.set(null);
		logger.info("ControllerInterceptor.afterCompletion()-----");
	}

}
