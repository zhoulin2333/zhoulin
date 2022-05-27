package co.jp.netwisdom.action;


import java.util.ArrayList;
import java.util.List;

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

public class UserUpdateAction extends Action{
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

		List hobbyList = new ArrayList();
		
		for(int i=0;i<hobbyArray.length;i++){
			 
			Hobby hobby1 = new Hobby();
			hobby1.setUsername(username);
			hobby1.setHobby(hobbyArray[i]);
			hobbyList.add(hobby1);
			
		}	
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		HobbyDAO hobbyDAO = new HobbyDAO();
		
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
        if(updateHobbyFlag=true){
        	System.out.println("用户信息表更新成功");
        }else{
        	System.out.println("用户信息更新失败");
        }

		return mapping.findForward("UserUpdateSuccess");

		
	}
}