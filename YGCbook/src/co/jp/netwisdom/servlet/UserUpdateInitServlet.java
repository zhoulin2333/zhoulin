package co.jp.netwisdom.servlet;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserUpdateInitServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 

		//姓名
		String username = request.getParameter("username");

		UserinfoDAO userinfoDAO = new UserinfoDAO();
		List<UserinfoHobby> list = userinfoDAO.findUserinfoAndHobby(username);

		List<UserinfoHobbyDto> dtos = new ArrayList<UserinfoHobbyDto>();
		
		//Map<String, String>  userNameMap  = new HashMap<String, String>();
		//标识dtos是否被创建
		List<String> userNames =  new ArrayList<String>();
		
		
		System.out.println("用户信息如下：");
		
		for(UserinfoHobby userinfoHobby: list ){

			//当用户名不存在时，证明大的dtos未创建
			if(!userNames.contains(userinfoHobby.getUsername())){
				UserinfoHobbyDto dto =new UserinfoHobbyDto(userinfoHobby.getUsername(),userinfoHobby.getPassword(),
						userinfoHobby.getSex(),userinfoHobby.getMajor(),
						userinfoHobby.getIntro());
			
				//将创建的大的dtos加到画面展示list里去
				dtos.add(dto);
				//将用户名加到userNames中
				userNames.add(userinfoHobby.getUsername());
				//将爱好加进子dto中
				if(userinfoHobby.getHobby() != null){
					dto.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
				}
			}else{
				for(UserinfoHobbyDto temp : dtos){
					//如果当前对象的名字等于传入进来的名字时
					if(temp.getUsername().equals(userinfoHobby.getUsername())){
						if(userinfoHobby.getHobby() != null){
							//将重复姓名的爱好加入子dto中
							temp.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
						}
					}
				}
			}
		}
		for(UserinfoHobbyDto result : dtos){
			StringBuffer sb = new  StringBuffer ("");
			for(HobbyDto hobbyDto : result.getHobbyList()){
				sb.append(hobbyDto.getHobby());
			} 
			result.setHobbys(sb.toString());
			System.out.println(result.getHobbys());
		}
		//
		request.setAttribute("dto",dtos.get(0));
		
		if( true){
		//request.setAttribute("admin", admin);
		    request.getRequestDispatcher("/userReg.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/userReg.jsp").forward(request, response);
			
	    }
	}
    //                                    post                                       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//如果是post进来的仍要进行get方式
		this.doGet(request, response);
	}

}