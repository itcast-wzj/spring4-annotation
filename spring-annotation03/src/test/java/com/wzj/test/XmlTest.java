package com.wzj.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wzj.bean.Person;

public class XmlTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
		
		
		//�����bean��scope�ǵ�����,Ĭ����������ʱ�ͻ��ʼ������,�����õ��Ķ�����ͬһ��
		//�����bean��scope��prototype��,��������ʱ����ȥ��ʼ������,ֻ��ÿ�λ�ȡ��ʱ��Ż���÷�����������,�����õ��Ķ�����ͬһ��
//		Person p1 = (Person) ioc.getBean("person");
//		Person p2 = (Person) ioc.getBean("person");
//		System.out.println(p1 == p2);
	}
}
