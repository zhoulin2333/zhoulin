﻿<%@page language="java" import = "java.util.*" contentType = "text/html;charset=utf-8" %>
<%@page import="co.jp.netwisdom.dto.UserinfoHobbyDto" %>
<%@page import="co.jp.netwisdom.dto.HobbyDto" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>

<html>
  <head>
    <title>课后练习题</title>

  </head>


  <body>
	<form action="userSearch" >
		姓名:<input id="username" name="username">
		<br/>
                      性别:<input type="radio" name="sex" checked  id="sex1" value="0">男<input type="radio"  name="sex" id="sex2"  value="1">女<br>
		专业:<select id="major1" name = "major">
		    <option value=""></option>
			<option value="0">软件工程</option>
			<option value="1" >英语</option>
			<option value="2">数学</option>
		</select><br>		
		<input type="submit" value="检索">
		
		<br/>
		<br/>
		检索一揽
	    <hr>

             <%List<UserinfoHobbyDto> dtos =(List<UserinfoHobbyDto>)request.getAttribute("dtos");%>
             <%if(dtos != null){%>
              <table border = "1" align ="center" width ="90%">
                 <tr bgcolor = "yellow">
		               <td>姓名</td>
		               <td>密码</td>
		               <td>性别</td>
		               <td>爱好</td>
		               <td>专业</td>
		               <td>简介</td>
                  </tr>
             <% for(UserinfoHobbyDto dto : dtos){%>
                  <tr bgcolor = "red">
                       <td><%=dto.getUsername() %></td>
	                   <td><%=dto.getPassword() %></td>
	                   <td>
	                   <%
	                   if("0".equals(dto.getSex())){%>
	                	   <%= "男" %>
	                	   
	                   <% 
	                   }else{%>
	                       <%="女" %>
	                	   
	                   <%
	                   } %>
	                   </td>
	                   <td>
	         		   <% StringBuffer sb = new  StringBuffer ("");
	         		   
							for(HobbyDto hobbyDto : dto.getHobbyList()){ 
								
			
								sb.append(hobbyDto.getHobby() + ","); 
							} %>
							<%if(!"".equals(sb.toString())){%>
							   <%if(",".equals(sb.toString().substring(sb.toString().length()-1))){%>
								<%= sb.toString().substring(0, sb.toString().length()-1).replace("0", "足球").replace("1", "篮球").replace("2", "网球")%>
							
								      
							   <% }else{%>
								<%= sb.toString().replace("0", "足球").replace("1", "篮球").replace("2", "网球")%>
								
							   <%} %>
							<%}%>
							
						   
					  
					   
					   </td>
	                   <td>
	                    <%
	                   if("0".equals(dto.getMajor())){%>
	                	   <%= "软件工程" %>
	                	   
	                   <% 
	                   }else if("1".equals(dto.getMajor())){%>
	                       <%="英语" %>
	                	   
	                   <%
	                   }else{  %>
	                       <%="数学"%>
	                   <%
	                   } %>
	                   </td>
	                   <td><%=dto.getIntro()%></td>
                  </tr>
             <%}%>
              </table>
            <%}%>

       
	</form>
  </body>
</html>