package co.jp.netwisdom.servlet;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.key.dao.BookInfoDAO;
import cn.key.dao.SysAdminDAO;
import cn.key.entity.SysAdmin;
import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;

public class UserRigsterServlet extends HttpServlet {

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
		
		//爱好 TODO
		String[] hobbyArray = request.getParameterValues("hobby");

		
		List hobbyList = new ArrayList();
		
		for(int i=0;i<hobbyArray.length;i++){
			 
			Hobby hobby1 = new Hobby();
			hobby1.setUsername(username);
			hobby1.setHobby(hobbyArray[i]);
			hobbyList.add(hobby1);
			
		}
		
//		Hobby hobby1 = new Hobby();
//		hobby1.setUsername(username);
//		hobby1.setHobby(hobbyArray[0]);
//		
//		Hobby hobby2 = new Hobby();
//		hobby2.setUsername(username);
//		hobby2.setHobby(hobbyArray[1]);
//		 
//		Hobby hobby3 = new Hobby();
//		hobby3.setUsername(username);
//		hobby3.setHobby(hobbyArray[2]);
//		
//		
//		List hobbyList = new ArrayList(); 
//		hobbyList.add(hobby1);
//		hobbyList.add(hobby2);
//		hobbyList.add(hobby3);
//		
		
		HobbyDAO hobbyDAO = new HobbyDAO();
		//dao.save(hobbyList);
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		//用户信息表更新
		//boolean result = dao.save(new Userinfo(userName,passWord,sex,major,intro));
	
	    boolean successFlag = true;
		//用户信息表登录
        if(userinfoDAO.save(new Userinfo(username,password,sex,major,intro))){
        	System.out.println("用户信息表插入成功");
        }else{
        	System.out.println("用户信息表插入失败");
        	successFlag =  false;
        }
        //用户爱好表登录
        if(hobbyDAO.save(hobbyList)){
        	System.out.println("用户爱好表插入成功");
        }else{
        	System.out.println("用户爱好表插入失败");
        	successFlag =  false;
        }

		if(successFlag = true){
		//request.setAttribute("admin", admin);
		    request.getRequestDispatcher("/CopyuserReg.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/CopyuserReg2.jsp").forward(request, response);
			
		}
	}
    //                                    post                                       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//如果是post进来的仍要进行get方式
		this.doGet(request, response);
	}

}