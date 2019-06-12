package com.wzj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.wzj.bean.Person;

@Configuration
public class MyConfig {
	
	/*
		bean�����������Ĭ�Ͼ��ǵ���,��������ʱ�ͳ�ʼ������,������ȡ��ʱ��Ż���÷��������������ʹ��������@Lazy
		���ʹ��prototypeʱ,��������ʱ����ȥ��ʼ������,ֻ��ÿ�λ�ȡ��ʱ��Ż���÷�����������,����ȡ�����Ķ�����ͬһ��!
	 */
	@Scope("prototype")
	@Bean("person")
	public Person person() {
		return new Person();
	}
}
