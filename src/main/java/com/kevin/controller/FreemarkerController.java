package com.kevin.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kevin.entity.User;

/**
 * <b>function:</b> FreeMarker示例控制器
 *
 * @author hoojo
 * @createDate 2013-8-6 下午04:50:10
 * @file FreemarkerController.java
 * @package edu.gduf.liu.controller
 * @project SpringFreemarker
 * @version 1.0
 */
@Controller
@RequestMapping("/freeMarker")
public class FreemarkerController {
	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/hello")
	public String sayHello(ModelMap map) {
		//System.out.println("say Hello ……");
		logger.info("say Hello ……");
		map.addAttribute("name", "liu");
		return "hello";
	}
	@RequestMapping("/hello2")
	public String sayHello(String name,ModelMap map) {
		//System.out.println("say Hello ……");
		logger.info("say Hello2 ……");
		map.addAttribute("name", name);
		return "hello2";
	}

	@RequestMapping("/hi")
	public String sayHi(ModelMap map) {
		System.out.println("say hi ……");
		map.put("name", "jojo");
		return "hi";
	}

	@RequestMapping("/jsp")
	public String jspRequest(ModelMap map) {
		System.out.println("jspRequest ……");
		map.put("name", "jsp112");
		User user = new User();
		user.setName("kevin");
		map.put("user", user);
		/*
		 * ModelAndView mv = new ModelAndView("test"); mv.addObject("name",
		 * "My First Spring Mvc");
		 */
		return "test";
		// return "/temp";
	}
}
