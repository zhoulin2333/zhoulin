package co.jp.netwisdom.action;

 



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.dto.UserDelDto;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserDelService;
@Controller(value="/userDel")
public class UserDelAction extends Action {
	@Autowired
	private UserDelService userDelService = new UserDelService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		UserDelDto dto = new UserDelDto();
		//姓名
		dto.setUsername(userForm.getUsername());
		
		userDelService.userDel(dto);
	
	    return mapping.findForward("UserDelSuccess");
	}

	public UserDelService getUserDelService() {
		return userDelService;
	}

	public void setUserDelService(UserDelService userDelService) {
		this.userDelService = userDelService;
	}
	
}