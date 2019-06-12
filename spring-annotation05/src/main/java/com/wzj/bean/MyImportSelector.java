package com.wzj.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑来返回需要导入的组件
public class MyImportSelector implements ImportSelector {

	@Override
	/**
	 * 1.AnnotationMetadata: 当前标注@Import类的所有注解信息 
	 * 2.该方法的返回值就是导入到容器中的组件全类名
	 */
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		//不能返回null,会报错,Debug调试看看,要返回空返回一个 new String[]{}
		return new String[] {"com.wzj.bean.Blue","com.wzj.bean.Red"};
	}

}
