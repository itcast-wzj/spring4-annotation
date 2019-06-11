package com.wzj.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wzj.MyConfig;
import com.wzj.bean.Person;

/*
	Ϊ�˺�xml��ʽ�γ������ĶԱ�, ����û��spring-test��ʽ
 */
public class AnnotationTest2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println();
		
		Person person = (Person) ioc.getBean("person");
		System.out.println(person);
	}
}
