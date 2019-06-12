package com.wzj.filtertype;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/*
 	我为什么知道 CUSTOM 就要实现TypeFilter呢？
 	作者在上面写了注释, 所以没事多看看
 	{@link org.springframework.core.type.filter.TypeFilter} implementation.
 	
 	使用这种方式,可以自己自定义扫描的规则
 	
 */
public class MyFilterType implements TypeFilter{

	/**
	 * metadataReader: 读取到的当前正在扫描类的信息
	 * MetadataReaderFactory:可以获取到其他任何类的信息
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		
		//获取当前类资源:(类路径)
		Resource resource = metadataReader.getResource();
		
		//获取当期正在扫描类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		String className = classMetadata.getClassName();
//		System.out.println(className);
//		if(className.contains("er")) {
//			return true;
//		}
		//我这里没放行, 所以没扫到容器中去
		return false;
	}

}
