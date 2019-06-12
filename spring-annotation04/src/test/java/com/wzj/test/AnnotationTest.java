package com.wzj.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wzj.MyConfig;

/*
	为了和xml方式形成鲜明的对比, 特意没用spring-test方式
 */
public class AnnotationTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);
		String osName = ioc.getEnvironment().getProperty("os.name");
		System.out.println("当前环境为: "+osName);
		
		//获取容器中的名字
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		/*
		 	因为我的运行环境是windows10: 所以注入的是比尔盖茨,
		 	那么我如何测试liunx环境呢？
		 	在Run-Configurations-Arguments-VM Arguments:
		 	输出 -Dos.name=liunx
		 */
	}
}
