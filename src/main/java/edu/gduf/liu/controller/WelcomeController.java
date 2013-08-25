package edu.gduf.liu.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wel")
public class WelcomeController {
	// get log4j handler
	private static final Logger logger = Logger
			.getLogger(WelcomeController.class);

	@RequestMapping(value = "/wel", method = RequestMethod.GET)
	protected ModelAndView doWelcome() {

		ModelAndView model = new ModelAndView("WelcomePage");
		model.addObject("msg", "Hello ~ Log4j");

		// log it via log4j
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}

		return model;
	}
}