package com.wzj.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	/**
	 * AnnotationMetadata: 当前类的注解信息 BeanDefinitionRegistry: BeanDefinition注册类
	 * 把所有需要添加到容器中的bean, 调用 BeanDefinitionRegistry.registerBeanDefinition() 手动注册进来
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 下面代码的意思就是,如果容器中存在名字为com.wzj.bean.Blue的Bean,我才将名为green,类型为Green的Bean注入容器中
		boolean flag = registry.containsBeanDefinition("com.wzj.bean.Blue");
//				System.out.println(flag);
		if (flag) {
			// 指定bean的定义信息 (bean类型,等等)
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Green.class);
			// 注册一个bean,指定bean名
			registry.registerBeanDefinition("green", beanDefinition);
		}

	}

}
