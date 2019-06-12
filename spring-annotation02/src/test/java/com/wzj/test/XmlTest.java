package com.wzj.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
		//���ǻ�ȡ���������е�bean����
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
