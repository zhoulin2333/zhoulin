package co.jp.zhoulin.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.key.dao.BookInfoDAO;
import cn.key.entity.BookInfo;
import co.jp.zhoulin.dao.MyhobbyDAO;
import co.jp.zhoulin.dao.RxUserDAO;
import co.jp.zhoulin.entity.Myhobby;
import co.jp.zhoulin.entity.RxUser;

public class RxUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		//姓名
		String username = request.getParameter("username");
		//密码
		String password = request.getParameter("password");
		//性别
		String sex = request.getParameter("sex");
		//专业
		String major = request.getParameter("major");
		//简介
		String intro = request.getParameter("intro");
		
		//爱好                                      数组的情况要取相应的value值
		String[] myhobby = request.getParameterValues("hobby");
		
		
		
		//创建一个hobby表的集合 装接到的数据
		List<Myhobby>  hobbylist = new ArrayList<>();
		//遍历 数组里的数据
		for(int i = 0;i<myhobby.length;i++){
			 //创建一个无参的Myhobby类
			 Myhobby myHobby1 = new Myhobby();
			 //赋值给每一个属性
			 myHobby1.setUsername(username);
			 myHobby1.setHobby(myhobby[i]);
			 //将每一个对象装进集合中
			 hobbylist.add(myHobby1);
		}
		
		
		//创建rxUser  dao方法
		RxUserDAO rxUserdao = new RxUserDAO();
		
		if (rxUserdao.save(new RxUser( username, password, sex, major, intro))) {
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
		}
		
		//创建Myhobby dao方法
		MyhobbyDAO myhobbydAO = new MyhobbyDAO();
		
		if (myhobbydAO.save( hobbylist)){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}