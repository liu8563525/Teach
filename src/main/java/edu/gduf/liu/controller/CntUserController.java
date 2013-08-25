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
@RequestMapping("/cntUserPage")
public class CntUserController {

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
		int totalRows = userService.countCntAll();
		int endRow = page.getCurrentPage()*page.getPageSize();
		int startRow = endRow-page.getPageSize();
		page.setTotalRows(totalRows);
		page.setPageStartRow(startRow);
		page.setPageEndRow(endRow);
		/*if (!StringUtils.isBlank(currentPage)) {
		page.setCurrentPage(Integer.parseInt(currentPage)+1);
		}*/

		ModelAndView mv = new ModelAndView("myCntPage");
		mv.addObject("userlist", userService.getCntUsers(page));
		mv.addObject("page", page);
		return mv;
	}

}
