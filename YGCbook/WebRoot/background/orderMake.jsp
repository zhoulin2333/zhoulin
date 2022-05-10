<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>�ƹ��������� ��   - ��������</title>
    <link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
  </head>
  
  <body>
  	<table>
  		<caption>�ƹ���������ǹ���Ա��Ϣ�б�</caption>
  		<tr>
  			<th>�������</th>
  			<th>�ͻ����</th>
  			<th>���</th>
  			<th>����״̬</th>
  			<th>�ջ�������</th>
  			<th>�ջ����绰</th>
  			<th>�ջ�����ַ</th>
  			<th>������...</th>
	  		<th>�������</th>
  		</tr>
  		<c:forEach var="info" items="${requestScope.mains}" > 
  			<tr onmouseout="this.bgColor='white'" onmouseover="this.bgColor='#66CCFF'">
	  			<td>${info.oid}</td>
	  			<td>${info.customerId}</td>
	  			<td>${info.moneyCount}</td>
	  			
	  			<c:if test="${info.sates == 1}">     
	          		<td width="50" class="wr4">δ����</td>
	          	</c:if>
	          
	          	<c:if test="${info.sates == 2}">     
	          		<td width="50" class="wr4">���ڴ���...</td>
	          	</c:if>
	          
	         	<c:if test="${info.sates == 3}">     
	          		<td width="50" class="wr4">�Ѵ���</td>
	          	</c:if>
	  			<td>${info.shouName}</td>
	  			<td>${info.shouTel}</td>
	  			<td>${info.shouAddress}</td>
  			<c:if test="${sessionScope.sysAdmin.adminType == 1}" var="result" >
  				<td><a href="${pageContext.request.contextPath}/UpOrderStatesServlet?oid=${info.oid}&states=2">����...</a>
  				</td>
  				<td><a href="${pageContext.request.contextPath}/UpOrderStatesServlet?oid=${info.oid}&states=3">�������</a></td>
  			</c:if>
  			<c:if test="${!result}">
				<td>��Ȩ��</td>
  				<td>��Ȩ��</td>
  			</c:if>
		</c:forEach>
		<%--
		<tr>
  			<td colspan="3">
  				<a id="wSJ" href="#" onclick="changeStates(1)">δ�ϼ�&nbsp;&nbsp;</a>
  				<a id="ySJ" href="#" onclick="changeStates(2)">���ϼ�&nbsp;&nbsp;</a>
  				<a id="bKY" href="#" onclick="changeStates(3)">������&nbsp;&nbsp;</a>
  				<a id="sY" href="#" onclick="changeStates(4)">��&nbsp;&nbsp;��</a>
  			</td>
  			<td colspan="7">
  				��${requestScope.nowPage}ҳ&nbsp;&nbsp;
  				��${requestScope.pageCount}ҳ&nbsp;&nbsp;&nbsp;&nbsp;
  				<c:if test="${nowPage == 1 || pageCount == 0}" var="re1">
  					��&nbsp;&nbsp;ҳ&nbsp;&nbsp;
	  				��һҳ&nbsp;&nbsp;
  				</c:if>
  				<c:if test="${!re1}">
  					<a id="first" href="#" onclick="goNowPage(1,5)">��&nbsp;&nbsp;ҳ&nbsp;&nbsp;</a>
	  				<a id="upPage" href="#" onclick="goNowPage('${nowPage-1}',5)">��һҳ&nbsp;&nbsp;</a>
  				</c:if>
  				<c:if test="${nowPage == pageCount || pageCount == 0}" var="re2">
  					��һҳ&nbsp;&nbsp;
	  				ĩ&nbsp;&nbsp;ҳ
  				</c:if>
  				<c:if test="${!re2}">
  					<a id="nextPage" href="#" onclick="goNowPage('${nowPage+1}',5)">��һҳ&nbsp;&nbsp;</a>
	  				<a id="end" href="#" onclick="goNowPage('${pageCount}',5)">ĩ&nbsp;&nbsp;ҳ</a>
  				</c:if>
	  			  	<select id="selectNowPage" onchange="goNowPage(this.value)">
	  			  	<c:forEach begin="1" end="${pageCount}" varStatus="sta" >
	  					<option value="${sta.count}" >
	  					��${sta.count}ҳ
	  					</option>
	  				</c:forEach>
	  			</select>
  			</td>
  		</tr>
  	--%>
  	</table>
  </body>
</html>
