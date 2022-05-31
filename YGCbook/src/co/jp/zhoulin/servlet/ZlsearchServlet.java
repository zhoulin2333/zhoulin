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

import org.omg.CORBA.Request;

import cn.key.dao.BookInfoDAO;
import cn.key.entity.BookInfo;
import co.jp.zhoulin.dao.MyhobbyDAO;
import co.jp.zhoulin.dao.RxUserDAO;
import co.jp.zhoulin.dto.HobbyDto;
import co.jp.zhoulin.dto.ZLUserHobbyDto;
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
		//初始化dao
		RxUserDAO rxUserDAO = new RxUserDAO();
		//初始化 将查询后的list赋值给dto
		List<ZLUserHobbyDto> dto = rxUserDAO.findNumAndHobby(username,sex,major);
		//初始化大的dto
		List<ZLuserHobbysDto>dtos = new ArrayList<ZLuserHobbysDto>();
		//初始化名字的list
		List<String> usernames = new ArrayList<>();
		//遍历经查询后拿到的数组
		for(ZLUserHobbyDto uh:dto){
			//new新的对象来接受传进来的值
			ZLuserHobbysDto zLuHDtos = new ZLuserHobbysDto();
			//赋值给姓名，密码，性别，爱好
			zLuHDtos.setUsername(uh.getUsername());
			zLuHDtos.setPassword(uh.getPassword());
			zLuHDtos.setSex(uh.getSex());
			zLuHDtos.setMajor(uh.getMajor());;
			//将当前数组中的名字传入名字数组中
			usernames.add(uh.getUsername());
			//判断当前名字是否与名字数组中的重复，若不重复
			if(!usernames.contains(uh.getUsername())){
				//将hobby加入zLuHDtos的hobbyList中
				//先是拿到大dto中的数组，然后用add方法向里面放hobbyDto类型的值
				zLuHDtos.getHobby().add(new HobbyDto(uh.getHobby()));
				//将新的对象装进大dto中
				dtos.add(zLuHDtos);
			}else{
				//若重复，遍历大的dto
				for(ZLuserHobbysDto temp:dtos){
					//如果大的dto中的姓名 与传进来的姓名相同
					if(temp.getUsername().equals(uh.getUsername())){
						//则将爱好加入此对象的dto数组中
						temp.getHobby().add(new HobbyDto(uh.getHobby()));
						
					}
				}
			}
		}
		request.setAttribute("dtos", dtos);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
