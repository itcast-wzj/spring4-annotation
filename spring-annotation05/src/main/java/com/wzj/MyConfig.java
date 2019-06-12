package com.wzj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.wzj.bean.ColorFactoryBean;
import com.wzj.bean.MyImportBeanDefinitionRegistrar;
import com.wzj.bean.MyImportSelector;
import com.wzj.bean.Person;

@Configuration
@Import({Person.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig {
	
	/**
 		給容器中注册组件:
	 	1. 包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)
	 	2. @Bean[导入第三方包里面的组件]
	 	3. @Import[快速給容器中导入一个组件],点击进入,该注解上面的注释为我们提供的方式!!!
	 		a. @Import(要导入到容器的组件), 容器会自动注册这个组件,id默认是全类名 
	 		b. ImportSelector接口: 返回需要导入的组件的全类名数组 [springBoot源码分析的时候,采用这种比较多]
	 		c. ImportBeanDefinitionRegistrar接口: 手动注册bean到容器中
	 	4.使用spring提供的FactoryBean(工厂 bean)
	 		a. 默认获取到是工厂bean调用getObject()获取的对象
	 		b. 要获取工厂bean本身,我们需要给id前面加个&
	 			例如: &colorFactoryBean
	 			这个是在 BeanFactory接口中定义的前缀 
   */	
	
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
