package com.wzj.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wzj.MyConfig;

/*
	为了和xml方式形成鲜明的对比, 特意没用spring-test方式
 */
public class AnnotationTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);
		
		//获取容器中的名字
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		//工厂bean获取的是调用getObject() 创建的对象
		Object bean = ioc.getBean("colorFactoryBean");
		System.out.println(bean.getClass().getName());
		
		//想要获取colorFactoryBean本身,需要在id前面加个&
		Object colorFactoryBean = ioc.getBean("&colorFactoryBean");
		System.out.println(colorFactoryBean.getClass().getName());
	}
}
