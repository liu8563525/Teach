package edu.gduf.liu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.gduf.liu.page.Page;
import edu.gduf.liu.page.PageContext;
import edu.gduf.liu.service.UserService;
import edu.gduf.liu.utils.HandlerResult;

@Controller
@RequestMapping("/myPage")
public class UserController {

	@Autowired
	private UserService userService;

	/*@RequestMapping("/")
	public ModelAndView listFirst(HttpServletRequest request) {
		Page page = Page.getContext();
		page.setTotalRows(userService.countAll());
		page.setPageStartRow(0);
		page.setPageEndRow(10);

		ModelAndView mv = new ModelAndView("myPage");
		mv.addObject("userlist", userService.getUsers(page));
		mv.addObject("page", page);
		return mv;
	}*/

	@RequestMapping(value = "/{pageToGo}", method = RequestMethod.GET)
	public ModelAndView listSpecificPage(@PathVariable String pageToGo,HttpServletRequest request) {
		Page page = Page.getContext();
		if (!StringUtils.isBlank(pageToGo)) {
			page.setCurrentPage(Integer.parseInt(pageToGo));
		}
		int totalRows = userService.countAll();
		int startRow = (page.getCurrentPage()-1)*page.getPageSize();
		page.setTotalRows(totalRows);
		page.setPageStartRow(startRow);

		ModelAndView mv = new ModelAndView("myPage");
		mv.addObject("userlist", userService.getUsers(page));
		mv.addObject("page", page);
		return mv;
	}

}
