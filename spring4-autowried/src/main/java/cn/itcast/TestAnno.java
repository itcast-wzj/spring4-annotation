package cn.itcast;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.itcast.controller.UserController;

public class TestAnno {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
		UserController userController = ioc.getBean(UserController.class);
		System.out.println(userController);
//		
//		UserService userService = ioc.getBean(UserService.class);
//		System.out.println(userService);
//		
//		System.out.println(userController.getService() == userService);
		
		ioc.close();
	}
}
