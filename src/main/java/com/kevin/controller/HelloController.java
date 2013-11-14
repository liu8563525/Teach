package com.kevin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

@SuppressWarnings("deprecation")
public class HelloController extends SimpleFormController {

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {

	    return new ModelAndView("hello");
	}
}
