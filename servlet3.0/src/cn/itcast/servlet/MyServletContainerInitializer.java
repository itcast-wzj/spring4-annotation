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

//容器启动的时候会将@HandlerTypes指定的这个类型下面的子类(实现类,子接口) 传递过来
//传入感兴趣的类型
@HandlesTypes(value= {UserService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

	/**
		应用启动的时候， 会运行onStartup方法
		Set<Class<?>> arg0： 感兴趣类型的所有子类型
		ServletContext arg1： 代表当前web应用的servletContext,一个web应用一个servletContext
		
		1）、使用ServletContext注册web组件【Servlet,Filter,Listener】
			我们用@webServlet,这种注解的方式,前提是我们自己写的类，可以这样注册
			但是如果我们使用第三方jar包里面的组件：如阿里巴巴的数据库连接池里面Filter
			我们就用不了注解了,你不能修改别人的代码吧【他是字节码 .class】, 我们要么在web.xml
			中配置, 要么使用如下方式！！！
	
		2)、使用编码的方式，在项目启动的时候给ServletContext里面添加组件
			必须在项目启动的时候来添加:
			a. ServletContainerInitializer 得到的ServletContext 【方法参数中】
			b. ServletContextListener 得到的ServletContext 【方法参数中】
		
		小细节： 测试ServletContextListener#contextDestroyed时点击 “Stop” 不要直接按停止按钮，否则不会出来效果
	 */
	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {
		System.out.println("传入感兴趣的类型");
		for (Class<?> clazz : arg0) {
			System.out.println(clazz);
		}
		
		/**
		 	启动服务器的控制台输出的效果 
		 	传入感兴趣的类型
			class cn.itcast.service.UserServiceImpl
			interface cn.itcast.service.UserServiceExt
			class cn.itcast.service.AbstractUserService
		 */
		
		//=================================
		//使用ServletContext注册组件
		//1.注册Servlet
		ServletRegistration.Dynamic addServlet = sc.addServlet("userServlet", new UserServlet());
		//配置servlet的映射信息
		addServlet.addMapping("/user");
		
		//2.注册Filter
		FilterRegistration.Dynamic addFilter = sc.addFilter("userFilter", UserFilter.class);
		//配置Filter的映射信息, 映射所有请求
		addFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		
		//3.注册Listner
		sc.addListener(UserListener.class);
	}

}
