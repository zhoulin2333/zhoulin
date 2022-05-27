﻿<%@page language="java" import = "java.util.*" contentType = "text/html;charset=utf-8" %>
<%@page import="co.jp.netwisdom.dto.UserinfoHobbyDto" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>



<html>
  <head>
    <title>用户注册画面</title>
    <script>
        function changeActionName(actionName){
        	document.getElementById("form").action = actionName ;
        	document.getElementById("username").disabled = false;
        }
        
    </script>
  </head>

  <% UserinfoHobbyDto dto = (UserinfoHobbyDto)request.getAttribute("dto"); %>
  <%if(dto != null){ %>
  <body>
	<form action="userUpdate.do"  id = "form">
	    
		<bean:message bundle="userResource" key="username"/>:<input disabled  id="username" name="username" value ="<%=dto.getUsername()%>" ><br>
		<bean:message bundle="userResource" key="password"/>:<input type="password" id="password" name = "password" value = "<%=dto.getPassword()%>"><br>
		<bean:message bundle="userResource" key="sex"/>:<input type="radio" name="sex" checked  id="sex1" value="0" <%if("0".equals(dto.getSex())){%> checked <%} %> ><bean:message bundle="userResource" key="man"/>
		<input type="radio"  name="sex" id="sex2"  value="1" <%if("1".equals(dto.getSex())){%> checked <%} %>><bean:message bundle="userResource" key="women"/><br>
		<bean:message bundle="userResource" key="hobby"/>:
		<input type="checkbox" name="hobby" value="0" <%if(dto.getHobbys().contains("0")){%> checked <%} %>><bean:message bundle="userResource" key="soccer"/>
		<input type="checkbox" name="hobby" value="1" <%if(dto.getHobbys().contains("1")){%> checked <%} %>><bean:message bundle="userResource" key="basketball"/>
		<input type="checkbox" name="hobby" value="2" <%if(dto.getHobbys().contains("2")){%> checked <%} %>><bean:message bundle="userResource" key="tennis"/>
		<br>
		
		
		<bean:message bundle="userResource" key="major"/>:<select id="major1" name = "major">
			<option value="0" <%if("0".equals(dto.getMajor())){%> selected <%} %>><bean:message bundle="userResource" key="soft"/></option>
			<option value="1" <%if("1".equals(dto.getMajor())){%> selected <%} %>><bean:message bundle="userResource" key="english"/></option>
			<option value="2" <%if("2".equals(dto.getMajor())){%> selected <%} %>><bean:message bundle="userResource" key="math"/></option>
		</select><br>
		<bean:message bundle="userResource" key="summary"/>:<br><textarea id="intro1"  name="intro"><%=dto.getIntro()%></textarea><br>
		 
		<input type="submit" value="<bean:message bundle="userResource" key="updateUser"/>" onclick = "changeActionName('userUpdate.do')">
		<input type="submit" value="<bean:message bundle="userResource" key="deleteUser"/>" onclick = "changeActionName('userDel.do')">
		<input type="button" value="<bean:message bundle="userResource" key="return"/>">
	</form>
  </body>
  <%}else{%>
  <body>
	<form action="userRegister.do" >
		<bean:message bundle="userResource" key="username"/>:<input id="username" name="username"  ><br>
		<bean:message bundle="userResource" key="password"/>:<input type="password" id="password" name = "password"><br>
		<bean:message bundle="userResource" key="sex"/>:<input type="radio" name="sex" checked  id="sex1" value="0" checked ><bean:message bundle="userResource" key="man"/>
		<input type="radio"  name="sex" id="sex2"  value="1" ><bean:message bundle="userResource" key="women"/><br>
		<bean:message bundle="userResource" key="hobby"/>:
		<input type="checkbox" name="hobby" value="0" ><bean:message bundle="userResource" key="soccer"/>
		<input type="checkbox" name="hobby" value="1" ><bean:message bundle="userResource" key="basketball"/>
		<input type="checkbox" name="hobby" value="2" ><bean:message bundle="userResource" key="tennis"/>
		<br>
		
		
		<bean:message bundle="userResource" key="major"/>:<select id="major1" name = "major">
			<option value="0" ><bean:message bundle="userResource" key="soft"/></option>
			<option value="1" ><bean:message bundle="userResource" key="english"/></option>
			<option value="2" ><bean:message bundle="userResource" key="math"/></option>
		</select><br>
		<bean:message bundle="userResource" key="summary"/>:<br><textarea id="intro1"  name="intro"></textarea><br>
		 
		<input type="submit" value="<bean:message bundle="userResource" key="registeredUser"/>">
		<input type="button" value="<bean:message bundle="userResource" key="return"/>">
	</form>
  </body>


<% }%>
</html>