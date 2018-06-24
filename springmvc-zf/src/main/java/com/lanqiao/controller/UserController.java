package com.lanqiao.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lanqiao.service.IUserService;
import com.lanqiao.vo.UserInfo;

@Controller  //控制器定义
@RequestMapping("/user")
public class UserController {
	
	//如果一个Controller类需要用到多个Service，那么你可注入多个Service
	@Resource
	IUserService userService;
	
	
	
	// /user/login， 只能处理post方式的请示，不指定则所请求方式都可地
	/**
	 * @param user 自动将请求中的参数注入到该对象的属性上，只要输入框的名字和类的属性名相同
	 * @param modelMap 其作用域为request
	 * @return
	 */
	@RequestMapping(value={"/login"},method={RequestMethod.POST}) 
	public String login(UserInfo user, ModelMap modelMap, HttpSession session){
		System.out.println(user);
		UserInfo userInfo = this.userService.selectForLogin(user);
		if (userInfo == null) {
			return "redirect:/login_form.jsp";
		}
		session.setAttribute("logUser", userInfo);
		modelMap.addAttribute("user", userInfo); //相当于把数据存入请求
		
		/*
		 * 返回的字符串默认为转发，返回的字符串会被
		 * org.springframework.web.servlet.view.InternalResourceViewResolver
		 * prefix="/views/"
		 * suffix=".jsp"
		 * 解析为一个视图的URL：/views/success.jsp
		 * 1. return "success";
		 * 2. return "forward:/views/list.jsp"; 说明：如带前缀forward: 但需指定视图全路径，InternalResourceViewResolver失效
		 * 3. return "forward:/user/reg";  转发控制器的其它方法继续处理请求
		 * 
		 * 重定向：
		 * 2. return "redirect:/user/list.jsp";  重定向到jsp
		 * 2. return "redirect:/user/reg";		 重定向到控制器的其它方法继续处理请求
		 */
		return "redirect:/house/list"; //被解析为： /views/list.jsp
	}

}
