package com.wzj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.wzj.filtertype.MyFilterType;
import com.wzj.service.UserService;

import org.springframework.context.annotation.ComponentScan.Filter;

/*
	@ComponentScan-�Զ�ɨ�����&ָ��ɨ�����
	ע���:
		1. ʹ�� includeFilters ��ʱ��һ��Ҫ����,useDefaultFilters=false
 */

//@ComponentScan value:ָ��Ҫɨ��İ�
//excluderFilters = Filter[] : ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[] :  ָ��ɨ���ʱ��ֻ�������Щ��� ��ע��:ֻ�н��õ�Ĭ�Ϲ���ֻ����(includeFilters)������Ч��
/*
	FilterType.ANNOTATION: ����ע��
	FilterType.ASSIGNABLE_TYPE: ���ո���������
	FilterType.CUSTOM: �Զ����������
	----������˽�----
	FilterType.ASPECTJ: ʹ��ASPECTJ���ʽ
	FilterType.REGEX: ʹ������
*/
//�����jdk8,����ʹ���ظ���@CompoentScan,��Ϊ�����и�@Repeatable,���ǵĻ�����ʹ��@ComponentScans����@Component,������Ͳ���ʾ��
@Configuration
@ComponentScan(basePackages= {"com.wzj"},includeFilters= {
		@Filter(type=FilterType.ANNOTATION,value= {Controller.class}),
		@Filter(type=FilterType.ASSIGNABLE_TYPE,value= {UserService.class}),
		@Filter(type=FilterType.CUSTOM,value= {MyFilterType.class})
},useDefaultFilters=false)
public class MyConfig {

}

