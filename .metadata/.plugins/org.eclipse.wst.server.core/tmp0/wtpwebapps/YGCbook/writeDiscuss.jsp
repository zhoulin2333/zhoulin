<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>�������� - �ƹ����������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<jsp:include page="fgLeft.jsp"></jsp:include>
	
 <td>
<table width="662" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td> 
      <div align="center" class="wr4"><b><font color="#BA6119">����</font><font color="#BA6119">����<a href="${pageContext.request.contextPath }/ShowBookInfoByIdServlet?bookId=${requestScope.bookId}">��${requestScope.bookName}��</a>һ�������</font></b></div>
    </td>
  </tr>
  <tr> 
    <td><img src="images/hb10.gif" width="662" height="41"></td>
  </tr>
  <tr> 
    <td background="images/hb01.gif" bgcolor="#FEFFEF"> 
      <table width="600" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr> 
          <td>&nbsp;</td>
        </tr>
        
        <tr> 
          <td>
          		<form name="myform" action="${pageContext.request.contextPath}/SaveDiscussServlet?bookId=${requestScope.bookId}&bookName=${requestScope.bookName}" method="post">
          			���ߣ�<input name="author" width="20" value="${sessionScope.customer.customerName}" readonly="readonly"><br>	
          			&nbsp;<br>
          			���ݣ�<textarea name="context" rows="5" cols="50"></textarea><br>
          			&nbsp;<br>
          			&nbsp;<br>
          			<input type="submit" name="submit" value="��������">
          		</form>
          </td>
          <%--<td background="images/h08.gif" class="wr4" width="74">
            	<div align="center"><input type="submit" name="submit" value="��������"></div>
          </td>
        --%>
        </tr>
        
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
        </tr>
      </table>
      
      
      <table border="0" cellspacing="0" cellpadding="1" align="center" height="21" width="163">
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
        </tr>
      </table>
    </td>
  <tr> 
    <td><img src="images/hb05.gif" width="662" height="10"></td>
  </tr>
</table>
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
</html>
<script ></script>