<%@page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="cn.key.entity.CustomerInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="cn.key.entity.Favorite"%>
<html>
<head>
<style>
<!--
.wr{font-size: 12pt; line-height: 22px}
.wr1 {	FONT-SIZE: 12px; LINE-HEIGHT: 200%}
.wr2 {	FONT-SIZE: 14px; LINE-HEIGHT: 150%}
.wr3 {	FONT-SIZE: 12px}
.wr4 {	FONT-SIZE: 12px; LINE-HEIGHT: 150%}
// -->
</style>
<title>�ҵ��ղؼ� - �ƹ����������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

	<jsp:include page="fgLeft.jsp"></jsp:include>
	<%List<Favorite> favorites = (List<Favorite>)request.getAttribute("favorites"); %>
    <td bgcolor="#F8FEE8"> 
      <table width="500" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td class="wr1"> 
            <div align="center"><b><font color="#F68217">�ҵ��ղؼ�</font></b></div>
          </td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td class="wr4"> </td>
        </tr>
      </table>
      <c:if test="${empty requestScope.favorites}" var="re">
      		<p align="center" class="wr4"><font color="#FF0000">����û���ղ���Ʒ����<a href="<%=request.getContextPath()%>/FindBookTypeServlet">����</a>�ղ�</font></p>
    </c:if>
    <c:if test="${!re}">
	  <table width="500" border="0" cellspacing="1" cellpadding="2" align="center" bgcolor="#000000">
        <tr align="center" bgcolor="#F8FEE8"> 

          <td width="50" class="wr4">���</td>
                
          <td width="130" class="wr4">ͼ������</td>
                
          <td width="50" class="wr4">ͼ����</td>
                
          <td width="130" class="wr4">�ղ�ʱ��</td>
                
          <td width="70" class="wr4">���빺�ﳵ</td>
                
          <td width="50" class="wr4">ɾ��</td>
              </tr>
              
                
          <% for(Favorite favorite : favorites) {%>
          		<tr bgcolor="#F8FEE8" align="center"> 
          			<td class="wr4"><%=favorite.getFavoriteId()%></td>
          			<td class="wr4"><a href="${pageContext.request.contextPath}/ShowBookInfoByIdServlet?bookId=<%=favorite.getBookId()%>"><%=favorite.getBookName()%></a></td>
          			<td class="wr4"><%=favorite.getBookId()%></td>
          			<td class="wr4"><%=favorite.getDate()%></td>
          			<td class="wr4"><a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=favorite.getBookId()%>">����</a></td>
          			<td class="wr4"><a href="<%=request.getContextPath()%>/DeleteFavoriteServlet?id=<%=favorite.getFavoriteId()%>" onclick="return isDelete('<%=favorite.getBookName()%>');">ɾ��</a></td>
          		</tr>
          <%	}
          %>
            </table>
      <table width="500" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td class="wr4">
          	<% CustomerInfo info = (CustomerInfo)session.getAttribute("customer"); %>
            <div align="right"><a href="<%=request.getContextPath()%>/ClearFavoriteServlet?id=<%=info.getCustomerId()%>" onclick="return isClear('<%=info.getCustomerName()%>')">ɾ�������ղ�</a></div>
          </td>
        </tr>
      </table>
   </c:if>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td> 
            <div align="right"><img src="images/daodu36.gif" width="593" height="58" alt="�����"></div>
          </td>
        </tr>
      </table>  
      <p align="center" class="wr1">������ | Ѱ��Ǽ� | �����Ѷ | �Ļ�ɳ�� | ���ƽ̨<br>
        ������� | ����� | ��ϵ����</p>
    </td>
  </tr>
</table>
<table width="770" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="22" background="images/dd-m09.gif">&nbsp;</td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td>&nbsp;</td>
    <td class="wr1" width="10">&nbsp;</td>
    <td class="wr1">&nbsp;</td>
  </tr>
  <tr> 
    <td><a href="http://www.qybook.com"><img src="images/dd-009.gif" width="36" height="40" alt="logo" border="0"></a></td>
    <td class="wr4" width="10">&nbsp;</td>
    <td class="wr4"> ��Ȩ���У�<a href="http://www.qingyun.com" target="_blank">�����ƹ����Ƽ��Ļ�ͼ���������ι�˾</a><br>
      ��ַ�������и���һ·25�Ŵ��´���һ¥������绰��029-8326696</td>
  </tr>
</table>
</body>
<script >
	function isDelete(bookName){
		return confirm("��ȷ��Ҫɾ�� ["+bookName+"] ��");
	}
	function isClear(customerName){
		return confirm("��ȷ��Ҫ��� ["+customerName+"]���ղؼ���Ϣ��");
	}
</script>
</html>
