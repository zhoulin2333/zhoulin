<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>�ƹ����������</title>
    <link rel="styleSheet" href="${pageContext.request.contextPath }/background/css/save.css" type="text/css" media="all" />
  </head>
  <body>
	<form action="${pageContext.request.contextPath }/SaveSysAdminServlet" method="post">
		<table>
			<caption>�ƹ����������-��������Ա</caption>
			<tr>
				<td>����Ա���ƣ�</td>
				<td><input name="adminName" size="40"></td>
			</tr>
			<tr>
				<td>����Ա���룺</td>
				<td><input type="password" name="pwd" size="40"></td>
			</tr>
			
			<tr>
				<td>����ԱȨ�ޣ�</td>
				<td>
					<input type="radio" name="states" value="1" >��������Ա
					<input type="radio" name="states" value="2" >��ͨ����Ա
					<input type="radio" name="states" value="3" checked>��������Ա
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="����"></td>
				<td><input type="reset" name="reset" value="����"></td>
			</tr>
		</table>
	</form>
  </body>
</html>
