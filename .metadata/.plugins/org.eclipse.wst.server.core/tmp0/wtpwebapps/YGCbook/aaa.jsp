<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK" 
     import="java.io.*,
          java.util.*,
          com.sun.image.codec.jpeg.*,
          java.awt.*,
          java.awt.image.*"%>
<%String result = (String)request.getAttribute("resultKey");%>
<form action="<%=request.getContextPath()%>/MyFirstMapping">
	<input type="text" name="key1"/>
	<input type="submit">
</form>
<table border="1px">
	<tr>
		<td>
			<%=result%>
		</td>
	</tr>
</table>

