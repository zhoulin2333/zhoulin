package co.jp.netwisdom.action;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dto.UserDelDto;
import co.jp.netwisdom.dto.UserNameDto;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UsernameCheckService;



public class UsernameCheckAction extends Action{
	UsernameCheckService usernameCheckService = new UsernameCheckService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		UserDelDto dto = new UserDelDto();
		//姓名
		dto.setUsername(userForm.getUsername());

        PrintWriter pw = response.getWriter();
        List<UserNameDto> userNameDto = usernameCheckService.usernameCheck(dto);
        //如果经查找 返回的数组为空
        if(userNameDto.size()>=1){
        	//如果经查找 返回的数组包含此名字，返回1
        	pw.print("1");
        }else{
        	//如果经查找 返回的数组不包含，返回0
        	pw.print("0");
        }
		return null;
	}
}