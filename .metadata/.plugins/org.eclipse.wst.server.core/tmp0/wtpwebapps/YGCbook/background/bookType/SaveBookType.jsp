<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>

<html>
  <head>
    <title>�ƹ��������������ͼ�����</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/save.css" type="text/css" media="all" />
  </head>
  
  <body>
	<form action="<%= request.getContextPath() %>/SaveBookTypeServlet" name="saveBookType" method="post">
		<table>
			<caption>�ƹ��������������ͼ������б�</caption>
			<tr>
				<td>ͼ�����</td>
				<td><input name="parentId" size="40"></td>
			</tr>
			<tr>
				<td>�Ƿ���ã�</td>
				<td>
					<input type="radio" name="isDelete" value="1" checked>����
					<input type="radio" name="isDelete" value="2">������
				</td>
			</tr>
			<tr>
				<td>������ƣ�</td>
				<td><input name="bookTypeName" size="40"></td>
			</tr>
			<tr>
				<td>������</td>
				<td><textarea cols="36" rows="4" name="context"></textarea> </td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="����"></td>
				<td><input type="reset" name="reset" value="����"></td>
			</tr>
		</table>
	</form>
  </body>
</html>
