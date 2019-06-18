package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	servlet3.0对应的web三大组件
 	servlet:  @WebServlet [还可以配置一些初始化参数,去注解里面的属性中看]
 	filter:   @WebFilter
 	listener: @WebListener
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.getWriter().print("hello Servlet3.0");
		}
}
