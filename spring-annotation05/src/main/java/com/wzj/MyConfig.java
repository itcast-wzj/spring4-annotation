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
 		�o������ע�����:
	 	1. ��ɨ��+�����עע��(@Controller/@Service/@Repository/@Component)
	 	2. @Bean[�������������������]
	 	3. @Import[���ٽo�����е���һ�����],�������,��ע�������ע��Ϊ�����ṩ�ķ�ʽ!!!
	 		a. @Import(Ҫ���뵽���������), �������Զ�ע��������,idĬ����ȫ���� 
	 		b. ImportSelector�ӿ�: ������Ҫ����������ȫ�������� [springBootԴ�������ʱ��,�������ֱȽ϶�]
	 		c. ImportBeanDefinitionRegistrar�ӿ�: �ֶ�ע��bean��������
	 	4.ʹ��spring�ṩ��FactoryBean(���� bean)
	 		a. Ĭ�ϻ�ȡ���ǹ���bean����getObject()��ȡ�Ķ���
	 		b. Ҫ��ȡ����bean����,������Ҫ��idǰ��Ӹ�&
	 			����: &colorFactoryBean
	 			������� BeanFactory�ӿ��ж����ǰ׺ 
   */	
	
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
