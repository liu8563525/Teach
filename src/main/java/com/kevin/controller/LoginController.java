package com.kevin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.kevin.common.HttpConstants;
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
	public String login(@ModelAttribute("user") User user, HttpServletRequest request) throws Exception {
		User tempUser=userService.getUser(user);
		JSONObject json = new JSONObject();
		if(tempUser==null){
			json.accumulate("result", "fail");
		}else{
			json.accumulate("result", "success");
		}
		Map<String, String> map=new HashMap<String, String>();
		map.put("result", "fail");
		String userString=JSON.toJSONString(map);
		json.accumulate("opmsg", "登录成功了!");
		logger.info("登录成功!");
		return userString;
	}

	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

}
