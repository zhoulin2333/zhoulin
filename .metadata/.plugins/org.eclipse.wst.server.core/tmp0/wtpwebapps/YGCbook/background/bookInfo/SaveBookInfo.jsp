<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>�ƹ����������</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/save.css" type="text/css" media="all" />
  </head>
  <body>
	<form action="${pageContext.request.contextPath}/SaveBookInfoServlet" name="saveBookType" method="post">
		<table>
			<caption>�ƹ��������������ͼ������б�</caption>
			<tr>
				<td>ͼ�����ƣ�</td>
				<td><input name="bookName" size="40"></td>
			</tr>
			<tr>
				<td>���ߣ�</td>
				<td><input name="author" size="40"></td>
			</tr>
			<tr>
				<td>ͼ������ţ�</td>
				<%--<td>
					<select name="bookTypeId">
						<c:forEach items="${requestScope.bookType}"></c:forEach>
					</select> 
				</td>
				--%><td><input name="booktypeId" size="40"></td>
			</tr>
			<tr>
				<td>ͼ��״̬��</td>
				<td>
					<input type="radio" name="bookStates" value="1" checked>����
					<input type="radio" name="bookStates" value="2">�ϼ�
					<input type="radio" name="bookStates" value="3">������
				</td>
			</tr>
			<tr>
				<td>���������ƣ�</td>
				<td><input name="pbName" size="40"></td>
			</tr>
			<tr>
				<td>���������ڣ�</td>
				<td><input name="pbdate" size="40"></td>
			</tr>
			<tr>
				<td>��׼�۸�</td>
				<td><input name="price" size="40"></td>
			</tr>
			<tr>
				<td>�ƹ����۸�</td>
				<td><input name="ygcprice" size="40"></td>
			</tr>
			<tr>
				<td>��ͼƬ��</td>
				<td><input name="bigImg" size="40"></td>
			</tr>
			<tr>
				<td>СͼƬ��</td>
				<td><input name="smallImg" size="40"></td>
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
