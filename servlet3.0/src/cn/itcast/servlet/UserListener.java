package cn.itcast.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//监听项目的启动和停止
public class UserListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("UserListener...contextDestroyed...");
	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		// TODO Auto-generated method stub
		ServletContext servletContext = sc.getServletContext();
		System.out.println("UserListener...contextInitialized...");
	}

}
