package co.jp.netwisdom.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.dto.UserUpdateDto;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserUpdateService;
@Controller(value="/userUpdate")
public class UserUpdateAction extends Action{
	@Autowired
	private UserUpdateService userUpdateService = new UserUpdateService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		UserUpdateDto dto = new UserUpdateDto();
		//姓名
		dto.setUsername(userForm.getUsername());
		//密码
		dto.setPassword(userForm.getPassword());
		//性别
		dto.setSex(userForm.getSex());
		//专业
		dto.setMajor(userForm.getMajor());
		//简介
		dto.setIntro(userForm.getIntro());
		
		//爱好 TODO
		dto.setHobbyArray(userForm.getHobby());
        
		
		userUpdateService.userUpdate(dto);
		
		return mapping.findForward("UserUpdateSuccess");
	}
	public UserUpdateService getUserUpdateService() {
		return userUpdateService;
	}
	public void setUserUpdateService(UserUpdateService userUpdateService) {
		this.userUpdateService = userUpdateService;
	}
	
}