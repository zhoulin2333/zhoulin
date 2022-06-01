package co.jp.netwisdom.action;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.form.UserForm;

public class UserRigsterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserForm  userForm = (UserForm)form;
		//姓名
		String username = userForm.getUsername();
		//密码
		String password = userForm.getPassword();
		//性别
		String sex = userForm.getSex();

		//专业
		String major = userForm.getMajor();
		//简介
		String intro = userForm.getIntro();
		
		//爱好 TODO
		String[] hobbyArray = userForm.getHobby();

		
		List<Hobby> hobbyList = new ArrayList<>();
		
		for(int i=0;i<hobbyArray.length;i++){
			 
			Hobby hobby1 = new Hobby();
			hobby1.setUsername(username);
			hobby1.setHobby(hobbyArray[i]);
			hobbyList.add(hobby1);
			
		}
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
        
		if( true){
			return mapping.findForward("UserRigSuccess");
		}else{
			return mapping.findForward("UserRigError");
		}
	}


}