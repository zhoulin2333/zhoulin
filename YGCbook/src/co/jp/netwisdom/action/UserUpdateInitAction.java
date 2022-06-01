package co.jp.netwisdom.action;

 
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserUpdateInitDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserUpdateInitService;

public class UserUpdateInitAction extends Action {
	UserUpdateInitService userUpdateInitServicenew = new UserUpdateInitService();
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
}