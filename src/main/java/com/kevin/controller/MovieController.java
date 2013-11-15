package com.kevin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kevin.service.UserService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Resource
	UserService userService;

	@RequestMapping(value = "/myname1/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
		userService.countAll();
		model.addAttribute("movie", name);
		return "list";

	}

	@RequestMapping(value = "/myname2", method = RequestMethod.POST)
	public String getMovie2(String name, ModelMap model) {
		userService.countAll();
		model.addAttribute("movie", name);
		return "list";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDefaultMovie(ModelMap model) {

		model.addAttribute("movie", "this is default movie");
		return "list";

	}

}