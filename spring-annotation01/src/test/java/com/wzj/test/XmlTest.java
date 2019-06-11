package com.wzj.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wzj.bean.Person;

public class XmlTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
		//这是获取容器中所有的bean名称
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		//ioc.getBeanNamesForType(Person.class); 这是获取指定类型的Bean名称 
		Person person = (Person) ioc.getBean("person");
		System.out.println(person);
	}
}
