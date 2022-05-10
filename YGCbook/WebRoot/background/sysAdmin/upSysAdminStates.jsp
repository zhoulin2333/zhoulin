<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>�ƹ����������</title>
    <link rel="styleSheet" href="${pageContext.request.contextPath }/background/css/save.css" type="text/css" media="all" />
  </head>
  <body>
	<form action="${pageContext.request.contextPath }/UpSysAdminStatesServlet" method="post">
		<table>
			<caption>�ƹ����������-����Ա����Ȩ��</caption>
			<tr>
				<td>����Ա��ţ�</td>
				<td><input name="adminId" size="40" value="${requestScope.admin.adminId}" readonly></td>
			</tr>
			<tr>
				<td>����Ա���ƣ�</td>
				<td><input name="adminName" size="40" value="${requestScope.admin.adminName}" readonly></td>
			</tr>
			<tr>
				<td>����ԱȨ�ޣ�</td>
				<td>
					<input type="radio" name="states" value="1" 
					<c:if test="${admin.adminType == 1 }">
						checked
					</c:if>
					>��������Ա
					<input type="radio" name="states" value="2"
					<c:if test="${admin.adminType == 2 }">
						checked
					</c:if>
					>��ͨ����Ա
					<input type="radio" name="states" value="3"
					<c:if test="${admin.adminType == 3 }">
						checked
					</c:if>
					>��������Ա
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
