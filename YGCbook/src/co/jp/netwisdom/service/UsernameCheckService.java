package co.jp.netwisdom.service;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.UserDelDto;
import co.jp.netwisdom.dto.UserNameDto;
import co.jp.netwisdom.form.UserForm;



public class UsernameCheckService {
	private UserinfoDAO userinfoDAO = new UserinfoDAO();
	
	public  List<UserNameDto> usernameCheck(UserDelDto dto){
		

        List<UserNameDto> userNameDto = userinfoDAO.findName(dto.getUsername());

		return userNameDto;
	}
}