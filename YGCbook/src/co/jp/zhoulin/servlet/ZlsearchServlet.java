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
import co.jp.zhoulin.dto.ZLuserHobbysDto;
import co.jp.zhoulin.entity.Myhobby;
import co.jp.zhoulin.entity.RxUser;

public class ZlsearchServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		//姓名
		String username = request.getParameter("username");
		//性别
		String sex = request.getParameter("sex");
		//专业
		String major = request.getParameter("major");

		
		RxUserDAO findUsername = new RxUserDAO();
		List<ZLuserHobbysDto> dtos = new ArrayList<>();
		List<E> dto = new ArrayList<>();
		
		
		
		
		
		

		
		if (findUsername.findNumAndHobby(username, sex, major)) {
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
		if( true){
		//request.setAttribute("admin", admin);
		    request.getRequestDispatcher("/usersearch.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/CopyuserReg2.jsp").forward(request, response);
			
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
