package com.wzj.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//�Զ����߼���������Ҫ��������
public class MyImportSelector implements ImportSelector {

	@Override
	/**
	 * 1.AnnotationMetadata: ��ǰ��ע@Import�������ע����Ϣ 
	 * 2.�÷����ķ���ֵ���ǵ��뵽�����е����ȫ����
	 */
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		//���ܷ���null,�ᱨ��,Debug���Կ���,Ҫ���ؿշ���һ�� new String[]{}
		return new String[] {"com.wzj.bean.Blue","com.wzj.bean.Red"};
	}

}
