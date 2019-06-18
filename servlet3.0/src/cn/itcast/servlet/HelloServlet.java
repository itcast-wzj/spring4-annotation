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
 	servlet3.0��Ӧ��web�������
 	servlet:  @WebServlet [����������һЩ��ʼ������,ȥע������������п�]
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
