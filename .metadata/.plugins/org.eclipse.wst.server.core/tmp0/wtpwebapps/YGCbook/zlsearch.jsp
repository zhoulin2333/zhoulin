﻿<%@page language="java" import = "java.util.*" contentType = "text/html;charset=utf-8" %>
<html>
  <head>
    <title>练习查询</title>
  </head>
  <body>
    <form action="zlsearch" name="form">
	           姓名：<input type = "text" id ="username" name = "username"><br/>
	           性别：<input type = "radio" id = "sex1" name="sex" value ="0" checked>男
	        <input type = "radio" id = "sex2" name="sex" value ="1" >女<br/>
	           专业：<select name="major">
	           <option value=""></option>
	           <option value="1">软件工程</option>
	           <option value="1">数学</option>
	           <option value="1">英语</option>
	        </select><br/>
	     <input type="submit" value ="检索"><br/><br/>
	           检索一览
	    <hr>
	    <center>
	    <table border = 1px style="width:80% ; text-align:center">
	       <tr>
	         <td>姓名</td>
	         <td>密码</td>
	         <td>性别</td>
	         <td>爱好</td>
	         <td>专业</td>
	         <td>简介</td>
	       </tr>
	    </table>
	    </center>
	     
    </form>
  </body>
</html>

