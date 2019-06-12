package com.wzj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.wzj.bean.Person;
import com.wzj.conditional.LiunxConditioal;
import com.wzj.conditional.WindowsConditioal;

//类中组件统一设置,满足当前条件,这个类中配置的所有bean的注册才能生效!!!
//@Conditional(value= {WindowsConditional.class})
@Configuration
public class MyConfig {
	
	/**
	 * @Conditional 按照一定的条件进行判断, 满足条件给容器注册bean
	 * 
	 * 需求
	 * 		如果是windows系统给我注册[比尔盖茨]进去
	 *  	如果是liuns系统给我注册 liunx之父进去
	 */
	@Conditional(WindowsConditioal.class)
	@Bean("比尔盖茨")
	public Person person01() {
		return new Person();
	}
	
	@Conditional(LiunxConditioal.class)
	@Bean("liunx之父")
	public Person person02() {
		return new Person();
	}
}
