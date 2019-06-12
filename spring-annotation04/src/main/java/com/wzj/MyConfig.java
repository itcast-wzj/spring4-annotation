package com.wzj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.wzj.bean.Person;
import com.wzj.conditional.LiunxConditioal;
import com.wzj.conditional.WindowsConditioal;

//�������ͳһ����,���㵱ǰ����,����������õ�����bean��ע�������Ч!!!
//@Conditional(value= {WindowsConditional.class})
@Configuration
public class MyConfig {
	
	/**
	 * @Conditional ����һ�������������ж�, ��������������ע��bean
	 * 
	 * ����
	 * 		�����windowsϵͳ����ע��[�ȶ��Ǵ�]��ȥ
	 *  	�����liunsϵͳ����ע�� liunx֮����ȥ
	 */
	@Conditional(WindowsConditioal.class)
	@Bean("�ȶ��Ǵ�")
	public Person person01() {
		return new Person();
	}
	
	@Conditional(LiunxConditioal.class)
	@Bean("liunx֮��")
	public Person person02() {
		return new Person();
	}
}
