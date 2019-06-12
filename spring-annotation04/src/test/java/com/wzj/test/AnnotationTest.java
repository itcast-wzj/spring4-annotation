package com.wzj.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wzj.MyConfig;

/*
	Ϊ�˺�xml��ʽ�γ������ĶԱ�, ����û��spring-test��ʽ
 */
public class AnnotationTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);
		String osName = ioc.getEnvironment().getProperty("os.name");
		System.out.println("��ǰ����Ϊ: "+osName);
		
		//��ȡ�����е�����
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		/*
		 	��Ϊ�ҵ����л�����windows10: ����ע����Ǳȶ��Ǵ�,
		 	��ô����β���liunx�����أ�
		 	��Run-Configurations-Arguments-VM Arguments:
		 	��� -Dos.name=liunx
		 */
	}
}
