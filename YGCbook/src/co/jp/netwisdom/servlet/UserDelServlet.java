package co.jp.netwisdom.servlet;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;

public class UserDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//姓名
		String username = request.getParameter("username");

		
		HobbyDAO hobbyDAO = new HobbyDAO();
		//dao.save(hobbyList);
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		//用户信息表更新
		//boolean result = dao.save(new Userinfo(userName,passWord,sex,major,intro));
	   
		
		
		//用户更新表Flag
	    boolean updateUserInfoFlag = true;
	    //用户信息表论理删除
	    updateUserInfoFlag = userinfoDAO.delUserinfo(username);
	  

        if(updateUserInfoFlag){
        	System.out.println("用户信息表删除成功");
        }else{
        	System.out.println("用户信息表删除失败");
        }
        
        
        
        
		//用户hobby更新表Flag
	    boolean updateHobbyFlag = true;
	    //用户hobby表论理删除
	    updateHobbyFlag = hobbyDAO.delHobby(username);


        if(updateHobbyFlag){
        	System.out.println("用户爱好表删除成功");
        }else{
        	System.out.println("用户爱好删除失败");
        }
		request.getRequestDispatcher("/usersearch.jsp").forward(request, response);

	}
    //                                    post                                       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//如果是post进来的仍要进行get方式
		this.doGet(request, response);
	}

}