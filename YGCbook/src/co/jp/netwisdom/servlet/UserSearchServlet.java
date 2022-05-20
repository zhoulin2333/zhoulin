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

public class UserSearchServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 

		//姓名
		String username = request.getParameter("username");
		//性别
		String sex = request.getParameter("sex");

		//专业
		String major = request.getParameter("major");
		
		

//		hobbyList.add(hobby3);
//		
		
		//HobbyDAO hobbyDAO = new HobbyDAO();
	
		
		
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		List<UserinfoHobby> list = userinfoDAO.findUserinfoAndHobby(username, sex, major);

		List<UserinfoHobbyDto> dtos = new ArrayList<UserinfoHobbyDto>();
		
		Map<String, String>  userNameMap  = new HashMap<String, String>();
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
		
		
		
			
			request.setAttribute("dtos",dtos);
			
			for(UserinfoHobbyDto result : dtos){
				System.out.println("-------------------");
				System.out.println("姓名：" + result.getUsername());
				System.out.println("密码：" + result.getPassword());
				System.out.println("性别：" + result.getSex());
				System.out.println("专业：" + result.getMajor());
				System.out.println("简介：" + result.getIntro());
				System.out.print("爱好：");
				 StringBuffer sb = new  StringBuffer ("");
				for(HobbyDto hobbyDto : result.getHobbyList()){
					
                    
					sb.append(hobbyDto.getHobby() + ",");
				}
				//当有爱好时才截取操作
				if(!"".equals(sb.toString())){
					if(",".equals(sb.toString().substring(sb.toString().length()-1))){
						System.out.println(sb.toString().substring(0, sb.toString().length()-1));
						
					}else{
						System.out.println(sb.toString());
					}
					
				}
				
				
               
//                List<> hbarr = new ArrayList<HobbyDto>();
//				for(HobbyDto hobbyDto : result.getHobbyList()){
//					
//					
//					System.out.print(hobbyDto.getHobby());
//					
//				}
//				System.out.println("");
//				System.out.println("-------------------");
				 
				
			}
	
			
			
		}

		
		
		
		System.out.println("取得成功");
		System.out.println("向画面进行表示");

		//用户信息表更新
		//boolean result = dao.save(new Userinfo(userName,passWord,sex,major,intro));
//	
//	    boolean successFlag = true;
//		//用户信息表登录
//        if(userinfoDAO.save(new Userinfo(username,password,sex,major,intro))){
//        	System.out.println("用户信息表插入成功");
//        }else{
//        	System.out.println("用户信息表插入失败");
//        	successFlag =  false;
//        }
//        //用户爱好表登录
//        if(hobbyDAO.save(hobbyList)){
//        	System.out.println("用户爱好表插入成功");
//        }else{
//        	System.out.println("用户爱好表插入失败");
//        	successFlag =  false;
//        }

		if( true){
		//request.setAttribute("admin", admin);
		    request.getRequestDispatcher("/usersearch.jsp").forward(request, response);
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