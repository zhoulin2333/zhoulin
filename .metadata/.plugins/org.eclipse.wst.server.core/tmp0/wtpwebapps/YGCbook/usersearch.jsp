<%@page language="java" import = "java.util.*" contentType = "text/html;charset=utf-8" %>
<%@page import="co.jp.netwisdom.dto.UserinfoHobbyDto" %>
<%@page import="co.jp.netwisdom.dto.HobbyDto" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>

<html>
  <head>
    <title>课后练习题</title>
    <script>
      function updateUser(username){
    	  window.location = "userUpdateInit.do?username="+username;
      }
      function deleteUser(username){
    	  window.location = "userDel.do?username="+username;
      }
      function delAll(){
    	  if(document.getElementById("allcheck").checked){
        	  var checkBoxsObj = document.getElementsByName("check");
        	  for(var i= 0;i<checkBoxsObj.length;i++){
        		  checkBoxsObj[i].checked = true ;
        	  }
    	  }else{
        	  var checkBoxsObj = document.getElementsByName("check");
        	  for(var i= 0;i<checkBoxsObj.length;i++){
        		  checkBoxsObj[i].checked = false ;
        	  }
    	  }
      }
      function del(){
    	  document.getElementById("form").action="delchecked.do";
    	  window.location = "delchecked.do?" ;
      }
    </script>

  </head>
  <body>
	<form action="userSearch.do" id="form" name="form">
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
                 <tr bgcolor = "#087670">
                       <td style="width:20"><input type ="checkbox" id="allcheck" name ="allcheck" onclick="delAll()"></td>
		               <td>姓名</td>
		               <td>密码</td>
		               <td>性别</td>
		               <td>爱好</td>
		               <td>专业</td>
		               <td>简介</td>
		               <td>更新</td>
		               <td>删除</td>
                  </tr>

              <% for(int line=0;line<dtos.size();line++){
                 
                   UserinfoHobbyDto dto = new UserinfoHobbyDto();
                		   dto = dtos.get(line);
                   
                 
                   %>
                  
                  <%if(line%2 == 0){ %><tr bgcolor = "#DEB887">
                  <%}else{ %><tr bgcolor = "#E9967A"><%} %>
                       <td><input type ="checkbox" id= "check" name ="check"  value ="<%=dto.getUsername()%>"></td>	
                       <td><a href= "userUpdateInit.do?username=<%=dto.getUsername()%>"><%=dto.getUsername()%></td>
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
	                   }%>
	                   </td>
	                   <td><%=dto.getIntro()%></td>
	                   <td style="width:20"><input type = "button" id="updateButton" name="updateButton" value = "更新" onclick="updateUser('<%=dto.getUsername()%>')"/></td>
                       <td style="width:20"><input type = "button" id="deleteButton" name="deleteButton" value = "删除" onclick="deleteUser('<%=dto.getUsername()%>')"/></td>
                  </tr>
              <%}%>
                  <tr align="center" bgcolor = "#087670"> 
                       <td colspan="9" ><input type = "submit" name="deleteall" value="一括删除" onclick="del()"></td>
                  </tr>
              </table>
            <%}%>
           
       
	</form>
  </body>
</html>