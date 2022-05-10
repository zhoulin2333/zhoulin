<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="cn.key.entity.BookType"%>

<html>
  <head>
    <title>�ƹ��������������ͼ�����</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/save.css" type="text/css" media="all" />
  </head>
  
  <body>
	<form action="<%= request.getContextPath() %>/UpdataBookTypeServlet" name="saveBookType" method="post">
	<% BookType type = (BookType)request.getAttribute("bookType"); %>
		<table>
			<caption>�ƹ��������������ͼ������б�</caption>
			<tr>
				<td>ͼ������ţ�</td>
				<td><input name="bookTypeId" size="40" value="<%= type.getBookTypeId()%>" readonly></td>
			</tr>
			<tr>
				<td>ͼ�����</td>
				<td><input name="parentId" size="40" value="<%= type.getParentId() %>"></td>
			</tr>
			<tr>
				<td>�Ƿ���ã�</td>
				<td>
					<input type="radio" name="isDelete" value="1" 
					<%if(type.getIsDelete() == 1) {%>
						checked
					<%}%>
					>����&nbsp;
					<input type="radio" name="isDelete" value="2"
					<%if(type.getIsDelete() == 2) {%>
						checked
					<%}%>
					>������
				</td>
			</tr>
			<tr>
				<td>������ƣ�</td>
				<td><input name="bookTypeName" size="40" value="<%= type.getBookTypeName() %>"></td>
			</tr>
			<tr>
				<td>������</td>
				<td><textarea cols="36" rows="4" name="context"><%= type.getContext()%></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="����"></td>
				<td><input type="reset" name="reset" value="����"></td>
			</tr>
		</table>
	</form>
  </body>
</html>
