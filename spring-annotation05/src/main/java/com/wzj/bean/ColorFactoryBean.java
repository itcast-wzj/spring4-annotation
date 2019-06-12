package com.wzj.bean;

import org.springframework.beans.factory.FactoryBean;

//创建一个spring定义的factoryBean
public class ColorFactoryBean implements FactoryBean<Color>{

	@Override
	//返回一个Color对象, 这个对象会被添加到容器中
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean....getObject()...");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	@Override
	//是否是单例
	public boolean isSingleton() {
		return true;
	}
	
}
