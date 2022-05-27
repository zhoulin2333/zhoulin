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

public class UserUpdateServlet extends HttpServlet {

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
		
		
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		HobbyDAO hobbyDAO = new HobbyDAO();
		//dao.save(hobbyList);
		
		//用户信息表更新
		//boolean result = dao.save(new Userinfo(userName,passWord,sex,major,intro));
	   
		
		
		//用户更新表Flag
	    boolean updateUserInfoFlag1 = true;
	    //用户信息表论理删除
	    updateUserInfoFlag1 = userinfoDAO.delUserinfo(username);
	    
	    boolean updateUserInfoFlag2 = true;
	    //进行更新操作
	    updateUserInfoFlag2 = userinfoDAO.save(new Userinfo(username,password,sex,major,intro));

        if(updateUserInfoFlag1==true && updateUserInfoFlag2 == true){
        	System.out.println("用户信息表更新成功");
        }else{
        	System.out.println("用户信息更新失败");
        }
        
        
        
        
		//用户hobby更新表Flag
	    boolean updateHobbyFlag = true;
	    //用户hobby表论理删除
	    updateHobbyFlag = hobbyDAO.delHobby(username);
	    //进行更新操作
	    updateHobbyFlag = hobbyDAO.save(hobbyList);

        if(updateHobbyFlag){
        	System.out.println("用户爱好表更新成功");
        }else{
        	System.out.println("用户爱好更新失败");
        }
		request.getRequestDispatcher("/userUpdatesuccess.jsp").forward(request, response);

	}
    //                                    post                                       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//如果是post进来的仍要进行get方式
		this.doGet(request, response);
	}

}