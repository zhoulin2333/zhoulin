package co.jp.netwisdom.action;

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.dto.UserRigsterDto;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserRigsterService;

@Controller(value="/userRegister")
public class UserRigsterAction extends Action {
	
	@Autowired
	private UserRigsterService userRigsterService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserForm  userForm = (UserForm)form;
		
		UserRigsterDto dto = new UserRigsterDto(); 
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
		dto.setHobby(userForm.getHobby());
	   
		boolean successFlag = userRigsterService.userRigster(dto);
        
		if(successFlag){
			return mapping.findForward("UserRigSuccess");
		}else{
			return mapping.findForward("UserRigError");
		}
	}

	public UserRigsterService getUserRigsterService() {
		return userRigsterService;
	}

	public void setUserRigsterService(UserRigsterService userRigsterService) {
		this.userRigsterService = userRigsterService;
	}
	
}