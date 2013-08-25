package edu.gduf.liu.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import edu.gduf.liu.entity.Client;

/**
 * ����������Controllerע��
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

	/**
	 * ӳ�䵽/welcome
	 */
	@RequestMapping(value = "/welcome")
	public ModelAndView welcome() {

		ModelAndView mv = new ModelAndView("welcome"); // ʹ��welcome.jsp�����д�����urlĬ��Ҳ��welcome.jsp
		mv.addObject("hello", "Hello"); // model������һ����Ϊhello���ַ�

		Client client = new Client();
		client.setName("User");
		mv.addObject("client", client); // ������һ����Ϊclient���Զ������

		return mv;
	}

	/**
	 * �����ҪModel��ֱ�ӷ�String��򵥣���Ӧ��viewΪlogin_page.jsp
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login_page";
	}

	/**
	 * һ������json�ķ�������ResponseBody��ʶ ������url�ж�������У�ʵ��RESTful����̫����
	 * ���κ������Դ�url��ȡ��Ҳ���Զ�����ͨ��
	 */
	@RequestMapping(value = "/client/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Client getClient(@PathVariable String name, String title) {
		Client client = new Client();
		client.setName(title + " " + name);

		return client;
	}
}