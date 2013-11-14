package com.kevin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kevin.page.PageContext;
import com.kevin.service.UserService;
import com.kevin.utils.HandlerResult;

@Controller
@RequestMapping("/user.do")
public class UserControllerOthers {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(params = ("method=list"))
	public ModelAndView listAll(HttpServletRequest request,HttpServletResponse response) {
		
		//可以将分页参数获取封装，已达到更好的复用效果。
		//page=2&pageSize=10&totalPages=19&totalRows=188
		String pagec = request.getParameter("page"); 
		String pageSize = request.getParameter("pageSize"); 
		String totalPages = request.getParameter("totalPages"); 
		String totalRows = request.getParameter("totalRows"); 
		
		//方法1：将分页参数直接放到mapper接口函数参数中，也可在对象中定义名字为page的属性，反射一样可以得到
		//后台连接直接获取
		//Page page = new Page();
		
		//方法2：不用进行map传参，用ThreadLocal进行传参,方便没有侵入性
		PageContext page = PageContext.getContext();
		
		//请自行验证
		if(null == pagec)
		{
			page.setCurrentPage(1);
			page.setPageSize(10);
		}
		else{
			page.setCurrentPage(Integer.parseInt(pagec));
			page.setPageSize(Integer.parseInt(pageSize));
			page.setTotalPages(Integer.parseInt(totalPages));
			page.setTotalRows(Integer.parseInt(totalRows));
		}
		page.setPagination(true);

//		方法1用
//		Map map = new HashMap();
//		map.put("page", page);
//		HandlerResult rs = userService.list(map);
		
		//方法2用
		HandlerResult rs = userService.list();
		
		ModelAndView mv = new ModelAndView("show");
		mv.addObject("userList", rs.getResultObj());
		mv.addObject("page",page);
		return mv;
	}

}
