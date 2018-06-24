package com.lanqiao.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lanqiao.service.IUserService;
import com.lanqiao.vo.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserServiceImplTest {
	
	@Resource
	IUserService userService; //注入了spring容器中的bean id="userService"

	@Test
	public void testSelectForLogin() {
		System.out.println(userService.getClass().getName());
		
		UserInfo userInfo = this.userService.selectForLogin(new UserInfo(null, "admin", "admin", null, null));
		System.out.println(userInfo);
	}

}
