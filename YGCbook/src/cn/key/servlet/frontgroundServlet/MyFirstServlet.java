package cn.key.servlet.frontgroundServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//C 拦截请求 发送跳转 2 接受发送值
public class MyFirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("key1");
		
		//传值给下一层
		String ooutput = input+input+input;
		//发送值给前台
		request.setAttribute("resultKey", ooutput);
		//清空参数
		request.getRequestDispatcher("aaa.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
