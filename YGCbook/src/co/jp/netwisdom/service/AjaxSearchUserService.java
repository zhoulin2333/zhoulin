package co.jp.netwisdom.service;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.taglibs.standard.lang.jpath.expression.Predicate;

import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.AjaxSearchUserDto;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.UserForm;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AjaxSearchUserService {
	private UserinfoDAO userinfoDAO = new UserinfoDAO();
	
	public List<UserinfoHobbyDto> ajaxSearchUser(AjaxSearchUserDto dto){
		List<UserinfoHobby> list = userinfoDAO.findUserinfoAndHobby(dto.getUsername(), dto.getSex(), dto.getMajor());

		List<UserinfoHobbyDto> dtos = new ArrayList<UserinfoHobbyDto>();
		
		//标识dtos是否被创建
		List<String> userNames =  new ArrayList<String>();
		
		
		System.out.println("用户信息如下：");
		for(UserinfoHobby userinfoHobby: list ){

			//当用户名不存在时，证明大的dtos未创建
			if(!userNames.contains(userinfoHobby.getUsername())){
				UserinfoHobbyDto uhdto =new UserinfoHobbyDto(userinfoHobby.getUsername(),userinfoHobby.getPassword(),
						userinfoHobby.getSex(),userinfoHobby.getMajor(),
						userinfoHobby.getIntro());
				//将创建的大的dtos加到画面展示list里去
				dtos.add(uhdto);
				//将用户名加到userNames中
				userNames.add(userinfoHobby.getUsername());
				//将爱好加进子dto中
				if(userinfoHobby.getHobby() != null){
					uhdto.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
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
		return dtos;
	}
}