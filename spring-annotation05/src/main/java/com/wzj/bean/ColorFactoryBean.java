package com.wzj.bean;

import org.springframework.beans.factory.FactoryBean;

//����һ��spring�����factoryBean
public class ColorFactoryBean implements FactoryBean<Color>{

	@Override
	//����һ��Color����, �������ᱻ��ӵ�������
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
	//�Ƿ��ǵ���
	public boolean isSingleton() {
		return true;
	}
	
}
