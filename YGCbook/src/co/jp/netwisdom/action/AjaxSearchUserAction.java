package co.jp.netwisdom.action;


import java.io.PrintWriter;
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
import org.apache.taglibs.standard.lang.jpath.expression.Predicate;

import co.jp.netwisdom.dto.AjaxSearchUserDto;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.AjaxSearchUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AjaxSearchUserAction extends Action{
	AjaxSearchUserService ajaxSearchUserService = new  AjaxSearchUserService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserForm  userForm = (UserForm)form;
		AjaxSearchUserDto dto =new AjaxSearchUserDto();
		//姓名
		dto.setUsername(userForm.getUsername());
		//性别
		dto.setSex(userForm.getSex());
		//专业
		dto.setMajor(userForm.getMajor());
		
		List<UserinfoHobbyDto> dtos = ajaxSearchUserService.ajaxSearchUser(dto);
		
		PrintWriter pw = response.getWriter();
		//把检索结果转换为json序列
		JSONArray json = JSONArray.fromObject(dtos);
		//生成json对象
		JSONObject jo = new JSONObject();
		//     key      json序列
		jo.put("data", json);
		pw.print(jo);
		pw.close();
		
		return null;
	}
}