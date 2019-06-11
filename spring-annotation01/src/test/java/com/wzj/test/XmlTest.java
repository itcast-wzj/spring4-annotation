package com.wzj.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wzj.bean.Person;

public class XmlTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
		//���ǻ�ȡ���������е�bean����
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		//ioc.getBeanNamesForType(Person.class); ���ǻ�ȡָ�����͵�Bean���� 
		Person person = (Person) ioc.getBean("person");
		System.out.println(person);
	}
}
