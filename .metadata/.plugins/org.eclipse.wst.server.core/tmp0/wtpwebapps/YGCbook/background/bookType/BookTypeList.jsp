<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="cn.key.entity.BookType"%>
<%@page import="cn.key.entity.SysAdmin"%>
<%
	Object object = session.getAttribute("sysAdmin");
	SysAdmin admin = null;
	if(object == null) {
		response.sendRedirect(request.getContextPath() + "/background/login.jsp");
	}else {
		admin = (SysAdmin)object;
	}
 %>
<html>
  <head>
    <title>�ƹ����������</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/body.css" type="text/css" media="all" />
  </head>
  
  <body>
  		<% 
  			List<BookType> list = (List<BookType>)request.getAttribute("bookType");
  		 %>
    <table>
    <caption>�ƹ����������ͼ������б�</caption>
    <tr>
    	<th>ͼ����</th>
    	<th>ͼ�������</th>
    	<th>�Ƿ����</th>
    	<th>ͼ���������</th>
    	<th>����</th>
    	<th>�޸�</th>
    	<th>������</th>
    </tr>
   	<% 
   	for(BookType book: list) {%>
   		<tr onmouseout="this.bgColor='white'" onmouseover="this.bgColor='#66CCFF'">
   			<td><%=book.getBookTypeId()%></td>
   			<td><%=book.getParentId()%></td>
   			<td><%=book.getIsDelete()%></td>
   			<td><%=book.getBookTypeName()%></td>
   			<td><%=book.getContext()%></td>
   			<% if(admin.getAdminType() < 3) {%>
   				<td><a href="<%= request.getContextPath() %>/FindBookTypeByIdServlet?bookTypeId=<%=book.getBookTypeId()%>">�޸�</a></td>
  				<td><a href="<%= request.getContextPath() %>/DeUpdateIsDeleteServlet?bookTypeId=<%=book.getBookTypeId()%>">������</a></td>
   			<% }else {%>
   				<th>��Ȩ��</th>
   				<th>��Ȩ��</th>	
   			<% } %>
   			
   		</tr>
   	<%} %>
   		<tr>
   			<td colspan="1">
   				<a href="<%=request.getContextPath()%>/background/bookType/SaveBookType.jsp">����</a>		
   			</td>
   			<td colspan="3">
   				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?isDelete=1">����&nbsp;&nbsp;</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?isDelete=2">������&nbsp;&nbsp;</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?isDelete=3">����</a>		
   			</td>
   			<td colspan="3">
   				&nbsp;
   			</td>
   		</tr>
    </table>
  </body>
</html>
