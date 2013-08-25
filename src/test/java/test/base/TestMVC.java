/*
 * 文件名：TestMVC.java
 * 版权：Copyright 2012-2012 Li Huaxin Tech. Co. Ltd. All Rights Reserved.
 * 描述： TestMVC.java
 * 修改人：lihuaxin
 * 修改时间：2012-8-28
 * 修改内容：新增
 */
package test.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Spring mvc 单元测试
 *
 * @author lihuaxin
 * @version LMS V100R001 2012-8-28
 * @since LMS V100R001C00
 */
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@Deprecated
public class TestMVC extends AbstractJUnit4SpringContextTests
{
	/*@Autowired
	private  HandlerMapping handlerMapping;
	@Autowired
    private  HandlerAdapter handlerAdapter;*/
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Autowired
    private HttpRequestHandlerAdapter handlerAdapter;

    /**
     *
     * 执行请求
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView excuteAction(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        HandlerExecutionChain chain = handlerMapping.getHandler(request);
        final ModelAndView model = handlerAdapter.handle(request, response, chain.getHandler());
        return model;
    }

    @Test
    public void testRequest()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setRequestURI("/movie/");
        request.setMethod("GET");
        // 执行URI对应的action
        try
        {
            final ModelAndView mav = this.excuteAction(request, response);
            // 执行结果
            System.out.println(mav.getViewName());
            Object msg = mav.getModelMap().get("roles");
            System.out.println(" = " + msg);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

