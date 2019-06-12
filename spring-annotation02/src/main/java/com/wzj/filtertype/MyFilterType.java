package com.wzj.filtertype;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/*
 	��Ϊʲô֪�� CUSTOM ��Ҫʵ��TypeFilter�أ�
 	����������д��ע��, ����û�¶࿴��
 	{@link org.springframework.core.type.filter.TypeFilter} implementation.
 	
 	ʹ�����ַ�ʽ,�����Լ��Զ���ɨ��Ĺ���
 	
 */
public class MyFilterType implements TypeFilter{

	/**
	 * metadataReader: ��ȡ���ĵ�ǰ����ɨ�������Ϣ
	 * MetadataReaderFactory:���Ի�ȡ�������κ������Ϣ
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//��ȡ��ǰ��ע�����Ϣ
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		
		//��ȡ��ǰ����Դ:(��·��)
		Resource resource = metadataReader.getResource();
		
		//��ȡ��������ɨ�������Ϣ
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		String className = classMetadata.getClassName();
//		System.out.println(className);
//		if(className.contains("er")) {
//			return true;
//		}
		//������û����, ����ûɨ��������ȥ
		return false;
	}

}
