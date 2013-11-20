package com.kevin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.kevin.common.HttpConstants;
import com.kevin.controller.util.SessionHelper;
import com.kevin.entity.User;
import com.kevin.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UserService userService;

	/*
	 * @RequestMapping(value="/login.spr",method=RequestMethod.POST) public
	 * ModelAndView login(@ModelAttribute("user")User user, String validcode,
	 * HttpSession session) throws Exception { ModelAndView mav = new
	 * ModelAndView(); session.setAttribute(SessionHelper.UserHandler, user);
	 * //mav.setViewName("redirect:/mg/userIndex.jsp");
	 * mav.setViewName("mg/userIndex"); mav.addObject("opmsg", "登录成功!");
	 * logger.info("登录成功!"); return mav; }
	 */

	/**
	 *
	 * @param user
	 * @param validcode
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login.spr", method = RequestMethod.POST, produces = HttpConstants.UTF8_JSON_CONTENTTYPE)
	@ResponseBody
	public String login(@ModelAttribute("user") User user, @RequestParam String name, HttpSession session) throws Exception {
		logger.error("name:"+name);
		User tempUser=userService.getUser(user);
		//JSONObject json = new JSONObject();
		Map<String, String> map=new HashMap<String, String>();
		if(tempUser==null){
			map.put("result", "fail");
			//json.accumulate("result", "fail");
			logger.info("用户:"+user+"登录失败!");
		}else{
			map.put("result", "success");
			//json.accumulate("result", "success");
			session.setAttribute(SessionHelper.UserHandler, user);
			logger.info("用户:"+user+"登录成功!");
		}
		//String userString=JSON.toJSONString(map);
		String userString=JSONUtils.toJSONString(map);
		logger.error(userString);
		return userString;
	}

	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

}
