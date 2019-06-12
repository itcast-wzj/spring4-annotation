package com.wzj.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wzj.MyConfig;

/*
	Ϊ�˺�xml��ʽ�γ������ĶԱ�, ����û��spring-test��ʽ
 */
public class AnnotationTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);
		//��ȡ������bean������
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
