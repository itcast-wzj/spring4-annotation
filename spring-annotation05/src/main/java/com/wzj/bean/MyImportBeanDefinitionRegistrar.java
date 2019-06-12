package com.wzj.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	/**
	 * AnnotationMetadata: ��ǰ���ע����Ϣ BeanDefinitionRegistry: BeanDefinitionע����
	 * ��������Ҫ��ӵ������е�bean, ���� BeanDefinitionRegistry.registerBeanDefinition() �ֶ�ע�����
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// ����������˼����,��������д�������Ϊcom.wzj.bean.Blue��Bean,�ҲŽ���Ϊgreen,����ΪGreen��Beanע��������
		boolean flag = registry.containsBeanDefinition("com.wzj.bean.Blue");
//				System.out.println(flag);
		if (flag) {
			// ָ��bean�Ķ�����Ϣ (bean����,�ȵ�)
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Green.class);
			// ע��һ��bean,ָ��bean��
			registry.registerBeanDefinition("green", beanDefinition);
		}

	}

}
