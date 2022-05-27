package co.jp.netwisdom.action;


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

import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.UserForm;

public class UserSearchAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		//姓名
		String username = userForm.getUsername();
		//性别
		String sex = userForm.getSex();
		//专业
		String major = userForm.getMajor();

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
				if(hobbyDto.getHobby() != null){
					sb.append(hobbyDto.getHobby() + ",");	
				}
			}
			//当有爱好时才截取操作
			if(!"".equals(sb.toString())){
				if(",".equals(sb.toString().substring(sb.toString().length()-1))){
					System.out.println(sb.toString().substring(0, sb.toString().length()-1));
					
				}else{
					System.out.println(sb.toString());
				}
				
			}
			
		}
				
		System.out.println("取得成功");
		System.out.println("向画面进行表示");
		
		return mapping.findForward("UserSearchSuccess");

	}
}