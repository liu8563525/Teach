package com.kevin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kevin.entity.User;


@Controller
@RequestMapping(value="/login")
public class LoginController {

	final Logger logger = Logger.getLogger(getClass());

	/*@RequestMapping(value="/login.spr",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user")User user, String validcode, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		session.setAttribute(SessionHelper.UserHandler, user);
		//mav.setViewName("redirect:/mg/userIndex.jsp");
		mav.setViewName("mg/userIndex");
		mav.addObject("opmsg", "登录成功!");
		logger.info("登录成功!");
		return mav;
	}*/

	/**
	 *
	 * @param user
	 * @param validcode
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login.spr", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(@ModelAttribute("user")User user, HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject();
		json.accumulate("result", "fail");
		json.accumulate("opmsg", "登录成功了!");
		//request.setAttribute("opmsg", "登录成功!");
		logger.info("登录成功!");
		logger.warn(json.toString());
		return json.toString();
	}

	@RequestMapping(value="/")
	public ModelAndView index()  {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

}
