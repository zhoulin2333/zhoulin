<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>


<html>
  <head>
    <title>��ʾҳ��-�ƹ����������</title>
  </head>
  
  <body>
  <br>
  <br>
  <br>
  	<p align="center">
  		<%=request.getAttribute("title")%>�����ɹ���
  		<a href="<%= request.getContextPath()%><%=request.getAttribute("returnPath")%>">�����ת</a>
  	</p>
  </body>
</html>
