package com.wzj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wzj.bean.Person;

//����spring����һ��������,������==�����ļ�
@Configuration
public class MyConfig {

	/*
	 	��ioc������ע��һ��bean,
	 	bean�������Ƿ�������ֵ������,
	 	bean��idĬ��Ϊ������, Ҳ����ͨ�� @Bean�����value�����޸�
	 */
	@Bean(value="person")
	public Person person1() {
		return new Person("wzj",22);
	}
}
