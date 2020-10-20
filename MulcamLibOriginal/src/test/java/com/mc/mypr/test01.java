package com.mc.mypr;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.user.service.UserService;
import biz.user.service.UserServiceImpl;
import biz.user.vo.UserVO;

public class test01 {

	public static void main(String[] args) {
		String[] xml = {"context.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(xml);
		UserService service = context.getBean("userservice",UserServiceImpl.class);
		List<UserVO> list = service.getUserList();
		for(UserVO vo : list) {
			System.out.println(vo);
		}
	}
}
