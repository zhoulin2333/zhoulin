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
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserSearchDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserSearchService;

public class UserSearchAction extends Action{
	UserSearchService userSearchService = new UserSearchService();
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
}