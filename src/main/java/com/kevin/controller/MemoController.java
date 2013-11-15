package com.kevin.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kevin.aop.AuthorityType;
import com.kevin.aop.FireAuthority;
import com.kevin.aop.Login;
import com.kevin.aop.ResultTypeEnum;
import com.kevin.controller.util.AjaxResult;


@Controller("memoController")
@RequestMapping(value = "/memo")
public class MemoController {

	final Logger logger = Logger.getLogger(getClass());

	/**
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	@Login(ResultTypeEnum.page)
	@RequestMapping(value = "/doSomeThing_a.spr", method = RequestMethod.GET)
	public ModelAndView doSomeThing_a() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		logger.info("doSomeThing_a");
		return mav;
	}
	/**
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	@Login(ResultTypeEnum.json)
	@RequestMapping(value = "/doSomeThing_b.spr", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doSomeThing_b() throws Exception {
		AjaxResult ar = new AjaxResult();
		ar.setResult(false);
		ar.setErrorMessage("操作成功!");
		logger.info(" doSomeThing_b ");
		return ar;
	}

	/**
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	@Login()
	@FireAuthority(authorityTypes=AuthorityType.SALES_ORDER_CREATE)
	@RequestMapping(value = "/doSomeThing_c.spr", method = RequestMethod.GET)
	public ModelAndView doSomeThing_c() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mg/userIndex");
		logger.info(" doSomeThing_c ");
		mav.addObject("opmsg", "调用成功!");
		return mav;
	}

	/**
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	@Login()
	@FireAuthority(authorityTypes=AuthorityType.SALES_ORDER_FIND)
	@RequestMapping(value = "/doSomeThing_d.spr", method = RequestMethod.GET)
	public ModelAndView doSomeThing_d() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mg/userIndex");
		logger.info(" doSomeThing_d ");
		mav.addObject("opmsg", "调用成功!");
		return mav;
	}

	/**
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	@Login(ResultTypeEnum.json)
	@FireAuthority(authorityTypes=AuthorityType.SALES_ORDER_CREATE, resultType=ResultTypeEnum.json)
	@RequestMapping(value = "/doSomeThing_e.spr", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doSomeThing_e() throws Exception {
		AjaxResult ar = new AjaxResult();
		ar.setResult(false);
		ar.setErrorMessage("操作成功!");
		logger.info(" doSomeThing_e ");
		return ar;
	}

	/**
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	@Login(ResultTypeEnum.json)
	@FireAuthority(authorityTypes=AuthorityType.SALES_ORDER_FIND, resultType=ResultTypeEnum.json)
	@RequestMapping(value = "/doSomeThing_f.spr", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doSomeThing_f() {
		AjaxResult ar = new AjaxResult();
		ar.setResult(false);
		ar.setErrorMessage("操作成功!");
		logger.info(" doSomeThing_f ");
		return ar;
	}

}
