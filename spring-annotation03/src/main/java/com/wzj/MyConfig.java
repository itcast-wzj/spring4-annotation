package com.wzj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.wzj.bean.Person;

@Configuration
public class MyConfig {
	
	/*
		bean的组件作用域默认就是单例,容器创建时就初始化对象,如果想获取的时候才会调用方法创建对象可以使用懒加载@Lazy
		如果使用prototype时,创建容器时不会去初始化对象,只有每次获取的时候才会调用方法创建对象,两次取出来的对象不是同一个!
	 */
	@Scope("prototype")
	@Bean("person")
	public Person person() {
		return new Person();
	}
}
