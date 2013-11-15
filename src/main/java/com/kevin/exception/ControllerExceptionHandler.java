package com.kevin.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
//@EnableWebMvc
public class ControllerExceptionHandler {

    @ModelAttribute
    public String message() {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        return "exception";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }

    /*@ExceptionHandler(SpringException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processUnauthenticatedException(NativeWebRequest request, SpringException e) {
        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");
        return "errors/showError"; //返回一个逻辑视图名
    }*/

    @ExceptionHandler(SpringException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processSpringException(SpringException exception) {
        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出SpringExceptionException异常时执行");
        ModelAndView andView = new ModelAndView();
		andView.setViewName("errors/showError");
		andView.addObject("exception", exception);
		//request.setAttribute("exception", e);
        return andView; //返回一个逻辑视图名
    }

    @ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException exception){
		ModelAndView andView = new ModelAndView();
		andView.addObject("exception", exception);
		andView.setViewName("showError");
		return andView;
	}
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(SQLException exception){
		ModelAndView andView = new ModelAndView();
		andView.addObject("exception", exception);
		andView.setViewName("errors/SQLError");
		return andView;
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleSQLException(RuntimeException exception){
		ModelAndView andView = new ModelAndView();
		andView.addObject("exception", exception);
		andView.setViewName("showError");
		return andView;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFound(HttpServletRequest request) {
        ModelAndView andView = new ModelAndView();
		andView.setViewName("errors/404");
        return andView; //返回一个逻辑视图名
    }
}
