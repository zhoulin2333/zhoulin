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


import co.jp.netwisdom.dto.UserSearchDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;

import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserSearchService;
@Controller(value="/userSearch")
public class UserSearchAction extends Action{
	@Autowired
	private UserSearchService userSearchService = new UserSearchService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		UserSearchDto dto = new UserSearchDto();
		//姓名
		dto.setUsername(userForm.getUsername());
		//性别
		dto.setSex(userForm.getSex());
		//专业
		dto.setMajor(userForm.getMajor());
		
		List<UserinfoHobbyDto> dtos = userSearchService.UserSearch(dto);
		request.setAttribute("dtos",dtos);

		return mapping.findForward("UserSearchSuccess");

	}
	public UserSearchService getUserSearchService() {
		return userSearchService;
	}
	public void setUserSearchService(UserSearchService userSearchService) {
		this.userSearchService = userSearchService;
	}
	
}