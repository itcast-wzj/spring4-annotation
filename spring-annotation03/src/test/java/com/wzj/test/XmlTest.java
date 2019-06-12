package com.wzj.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wzj.bean.Person;

public class XmlTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
		
		
		//如果该bean的scope是单例的,默认容器创建时就会初始化对象,两次拿到的对象是同一个
		//如果该bean的scope是prototype的,创建容器时不会去初始化对象,只有每次获取的时候才会调用方法创建对象,两次拿到的对象不是同一个
//		Person p1 = (Person) ioc.getBean("person");
//		Person p2 = (Person) ioc.getBean("person");
//		System.out.println(p1 == p2);
	}
}
