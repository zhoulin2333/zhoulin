<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>�ƹ��������� ��   - ����Ա��Ϣ</title>
    <link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
  </head>
  
  <body>
  	<table>
  		<caption>�ƹ���������ǹ���Ա��Ϣ�б�</caption>
  		<tr>
  			<th>����Ա���</th>
  			<th>����Ա����</th>
  			<th>Ȩ��</th>
  			<th>����Ȩ��</th>
  			<th>ɾ��</th>
  		</tr>
  		<c:forEach var="info" items="${requestScope.sysAdmins}" > 
  			<tr onmouseout="this.bgColor='white'" onmouseover="this.bgColor='#66CCFF'">
	  			<td>${info.adminId}</td>
	  			<td>${info.adminName}</td>
	  			<td>${info.adminType}</td>
  			<c:if test="${sessionScope.sysAdmin.adminType == 1}" var="result" >
  				<td><a href="${pageContext.request.contextPath}/FindByIdSysAdminServlet?adminId=${info.adminId}">Ȩ������</a>
  				</td>
  				<td><a href="${pageContext.request.contextPath}/DeleteSysAdminServlet?adminId=${info.adminId}" 
  					title="ɾ������Ա" onclick="return isDelete('${info.adminName}')">ɾ��</a></td>
  			</c:if>
  			<c:if test="${!result}">
				<td>��Ȩ��</td>
  				<td>��Ȩ��</td>
  			</c:if>
		</c:forEach>
		<tr>
			<c:if test="${sessionScope.sysAdmin.adminType == 1}" var="res">
	  			<td colspan="3">
	  				<a href="${pageContext.request.contextPath}/background/sysAdmin/saveSysAdmin.jsp">����</a>
	  			</td>
			</c:if>
			<c:if test="${!res}">
				<td>������Ȩ��</td>
	  		</c:if>
		</tr>
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
  <script type="text/javascript">
  	function isDelete(adminName) {
  		return confirm("ȷ��ɾ����" + adminName + "����");
  	}
  	var bookStates = '${requestScope.bookStates}';
  	function goNowPage(nowPage) {
  		var url = "${pageContext.request.contextPath}/FindAllBookInfoServlet?nowPage=" + nowPage + "&bookStates=" + bookStates;
  		window.location = url;
  	}
  	function changeStates(myStates){
  		bookStates = myStates;
  		goNowPage(1);
  	}
  	function init() {
  		var init = "sY";
  		if(bookStates == '1') {
  			init = "wSJ";
  		}else if(bookStates == '2') {
  			init = "ySJ";
  		}else if(bookStates == '3') {
  			init = "bKY";
  		}
  		document.getElementById(init).style.background = '#66CCFF';
  		document.getElementById("selectNowPage").value = "${nowPage}";
  	}
  </script>
</html>
