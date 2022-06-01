package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import co.jp.netwisdom.dto.DelcheckedDto;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.DelcheckedService;

public class DelcheckedAction extends Action {
	//一括删除
	DelcheckedService delcheckedService = new DelcheckedService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm  userForm = (UserForm)form;
		DelcheckedDto dto =  new DelcheckedDto();
		
		//姓名
		dto.setUsernames(userForm.getCheck());
		delcheckedService.delchecked(dto);
	    return mapping.findForward("delcheckedSuccess");
	
	}
}