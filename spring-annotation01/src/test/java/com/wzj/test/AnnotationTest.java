package com.wzj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wzj.MyConfig;
import com.wzj.bean.Person;

/*
	@ContextConfiguration ��ע�����������
	String[] locations() һ������xml��ʽ
	Class<?>[] classes() һ������ע�ⷽʽ
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {MyConfig.class})
public class AnnotationTest {
	
	@Autowired
	private ApplicationContext ioc;
	
	@Test
	public void test01() {
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println();
		
		//���ݷ�������ȡ
//		Person bean = (Person) ioc.getBean("person1");
		//����ָ�������ֻ�ȡ
		Person bean = (Person) ioc.getBean("person");
		System.out.println(bean);
	}
}
