package com.kevin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {

	    return new ModelAndView("hello");
	}
}
