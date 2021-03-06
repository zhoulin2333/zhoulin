package co.jp.netwisdom.action;



import java.util.List;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserUpdateInitDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserUpdateInitService;
@Controller(value="/userUpdateInit")
public class UserUpdateInitAction extends Action {
	@Autowired
	private UserUpdateInitService userUpdateInitServicenew = new UserUpdateInitService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		UserUpdateInitDto dto = new UserUpdateInitDto();
		//姓名
		dto.setUsername(userForm.getUsername());

		List<UserinfoHobbyDto> dtos = userUpdateInitServicenew.userUpdateInit(dto);
		request.setAttribute("dto",dtos.get(0));
	    return mapping.findForward("UserUpdateInitSuccess");
	}
	public UserUpdateInitService getUserUpdateInitServicenew() {
		return userUpdateInitServicenew;
	}
	public void setUserUpdateInitServicenew(UserUpdateInitService userUpdateInitServicenew) {
		this.userUpdateInitServicenew = userUpdateInitServicenew;
	}
	
}