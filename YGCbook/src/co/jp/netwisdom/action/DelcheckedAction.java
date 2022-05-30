package co.jp.netwisdom.action;

 



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;

import co.jp.netwisdom.form.UserForm;

public class DelcheckedAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		//姓名
		String[] usernames = userForm.getCheck();
		
		HobbyDAO hobbyDAO = new HobbyDAO();
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		
		for(String username : usernames){

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
		        	System.out.println("用户hobby表删除成功");
		        }else{
		        	System.out.println("用户hobby表删除失败");
		        }
        
		}
	    return mapping.findForward("delcheckedSuccess");
	
	}
}