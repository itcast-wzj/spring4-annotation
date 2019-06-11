package com.wzj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wzj.bean.Person;

//告诉spring这是一个配置类,配置类==配置文件
@Configuration
public class MyConfig {

	/*
	 	向ioc容器中注入一个bean,
	 	bean的类型是方法返回值的类型,
	 	bean的id默认为方法名, 也可以通过 @Bean里面的value属性修改
	 */
	@Bean(value="person")
	public Person person1() {
		return new Person("wzj",22);
	}
}
