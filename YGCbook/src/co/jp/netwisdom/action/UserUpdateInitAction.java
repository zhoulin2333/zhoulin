package co.jp.netwisdom.action;

 
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.UserForm;

public class UserUpdateInitAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		//姓名
		String username = userForm.getUsername();

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
	    return mapping.findForward("UserUpdateInitSuccess");
	}
}