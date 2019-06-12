package com.wzj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.wzj.filtertype.MyFilterType;
import com.wzj.service.UserService;

import org.springframework.context.annotation.ComponentScan.Filter;

/*
	@ComponentScan-自动扫描组件&指定扫描规则
	注意点:
		1. 使用 includeFilters 的时候一定要带上,useDefaultFilters=false
 */

//@ComponentScan value:指定要扫描的包
//excluderFilters = Filter[] : 指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] :  指定扫描的时候只需包含哪些组件 【注意:只有禁用掉默认规则只包含(includeFilters)才能生效】
/*
	FilterType.ANNOTATION: 按照注解
	FilterType.ASSIGNABLE_TYPE: 按照给定的类型
	FilterType.CUSTOM: 自定义包含规则
	----下面的了解----
	FilterType.ASPECTJ: 使用ASPECTJ表达式
	FilterType.REGEX: 使用正则
*/
//如果是jdk8,可以使用重复的@CompoentScan,因为里面有个@Repeatable,不是的话可以使用@ComponentScans包含@Component,我这里就不演示了
@Configuration
@ComponentScan(basePackages= {"com.wzj"},includeFilters= {
		@Filter(type=FilterType.ANNOTATION,value= {Controller.class}),
		@Filter(type=FilterType.ASSIGNABLE_TYPE,value= {UserService.class}),
		@Filter(type=FilterType.CUSTOM,value= {MyFilterType.class})
},useDefaultFilters=false)
public class MyConfig {

}

