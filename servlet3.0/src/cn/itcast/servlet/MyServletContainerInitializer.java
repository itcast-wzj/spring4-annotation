package cn.itcast.servlet;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import cn.itcast.service.UserService;

//����������ʱ��Ὣ@HandlerTypesָ��������������������(ʵ����,�ӽӿ�) ���ݹ���
//�������Ȥ������
@HandlesTypes(value= {UserService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

	/**
		Ӧ��������ʱ�� ������onStartup����
		Set<Class<?>> arg0�� ����Ȥ���͵�����������
		ServletContext arg1�� ����ǰwebӦ�õ�servletContext,һ��webӦ��һ��servletContext
		
		1����ʹ��ServletContextע��web�����Servlet,Filter,Listener��
			������@webServlet,����ע��ķ�ʽ,ǰ���������Լ�д���࣬��������ע��
			�����������ʹ�õ�����jar�������������簢��Ͱ͵����ݿ����ӳ�����Filter
			���Ǿ��ò���ע����,�㲻���޸ı��˵Ĵ���ɡ������ֽ��� .class��, ����Ҫô��web.xml
			������, Ҫôʹ�����·�ʽ������
	
		2)��ʹ�ñ���ķ�ʽ������Ŀ������ʱ���ServletContext����������
			��������Ŀ������ʱ�������:
			a. ServletContainerInitializer �õ���ServletContext �����������С�
			b. ServletContextListener �õ���ServletContext �����������С�
		
		Сϸ�ڣ� ����ServletContextListener#contextDestroyedʱ��� ��Stop�� ��Ҫֱ�Ӱ�ֹͣ��ť�����򲻻����Ч��
	 */
	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {
		System.out.println("�������Ȥ������");
		for (Class<?> clazz : arg0) {
			System.out.println(clazz);
		}
		
		/**
		 	�����������Ŀ���̨�����Ч�� 
		 	�������Ȥ������
			class cn.itcast.service.UserServiceImpl
			interface cn.itcast.service.UserServiceExt
			class cn.itcast.service.AbstractUserService
		 */
		
		//=================================
		//ʹ��ServletContextע�����
		//1.ע��Servlet
		ServletRegistration.Dynamic addServlet = sc.addServlet("userServlet", new UserServlet());
		//����servlet��ӳ����Ϣ
		addServlet.addMapping("/user");
		
		//2.ע��Filter
		FilterRegistration.Dynamic addFilter = sc.addFilter("userFilter", UserFilter.class);
		//����Filter��ӳ����Ϣ, ӳ����������
		addFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		
		//3.ע��Listner
		sc.addListener(UserListener.class);
	}

}
