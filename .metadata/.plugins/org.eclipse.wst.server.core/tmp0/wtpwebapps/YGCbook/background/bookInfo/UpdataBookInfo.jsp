<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>�ƹ����������</title>
    <link rel="styleSheet" href="${pageContext.request.contextPath }/background/css/save.css" type="text/css" media="all" />
  </head>
  <body>
	<form action="${pageContext.request.contextPath }/UpdataBookInfoServlet" name="saveBookType" method="post">
		<table>
			<caption>�ƹ����������-�޸�ͼ������б�</caption>
			<tr>
				<td>ͼ���ţ�</td>
				<td><input name="bookId" size="40" value="${requestScope.book.bookId}" readonly></td>
			</tr>
			<tr>
				<td>ͼ�����ƣ�</td>
				<td><input name="bookName" size="40" value="${requestScope.book.bookName}"></td>
			</tr>
			<tr>
				<td>���ߣ�</td>
				<td><input name="author" size="40" value="${requestScope.book.author}"></td>
			</tr>
			<tr>
				<td>ͼ������ţ�</td>
				<td>
					<select name="booktypeId">
						<c:forEach var="type" items="${requestScope.bookTypes}">
							<option value="${type.bookTypeId}"> ${type.bookTypeName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>ͼ��״̬��</td>
				<td>
					<input type="radio" name="bookStates" value="1" 
					<c:if test="${book.bookStates == 1 }">
						checked
					</c:if>
					>����
					<input type="radio" name="bookStates" value="2"
					<c:if test="${book.bookStates == 2 }">
						checked
					</c:if>
					>�ϼ�
					<input type="radio" name="bookStates" value="3"
					<c:if test="${book.bookStates == 3 }">
						checked
					</c:if>
					>������
				</td>
			</tr>
			<tr>
				<td>���������ƣ�</td>
				<td><input name="pbName" size="40" value="${requestScope.book.pbName}"></td>
			</tr>
			<tr>
				<td>���������ڣ�</td>
				<td><input name="pbdate" size="40" value="${requestScope.book.pbdate}"></td>
			</tr>
			<tr>
				<td>��׼�۸�</td>
				<td><input name="price" size="40" value="${requestScope.book.price}"></td>
			</tr>
			<tr>
				<td>�ƹ����۸�</td>
				<td><input name="ygcprice" size="40" value="${requestScope.book.ygcprice}"></td>
			</tr>
			<tr>
				<td>��ͼƬ��</td>
				<td><input name="bigImg" size="40" value="${requestScope.book.bigImg}"></td>
			</tr>
			<tr>
				<td>СͼƬ��</td>
				<td><input name="smallImg" size="40" value="${requestScope.book.smallImg}"></td>
			</tr>
			<tr>
				<td>������</td>
				<td><textarea cols="36" rows="4" name="context">${requestScope.book.context}</textarea> </td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="����"></td>
				<td><input type="reset" name="reset" value="����"></td>
			</tr>
		</table>
	</form>
  </body>
</html>
