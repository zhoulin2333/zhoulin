<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>�ҵĶ��� - �ƹ����������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
	
	<jsp:include page="fgLeft.jsp"></jsp:include>
	
    <td bgcolor="#F8FEE8"> 
      <table width="500" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td class="wr1">
            <div align="center"><b><font color="#F68217">�ҵĶ���</font></b></div>
          </td>
        </tr>
        <tr> 
          <td> <b></b></td>
        </tr>
        <tr> 
          <td class="wr4"> </td>
        </tr>
      </table>
	  <table width="500" border="0" cellspacing="1" cellpadding="2" align="center" bgcolor="#000000">
        <tr align="center" bgcolor="#F8FEE8"> 
                
          <td width="70" class="wr4">������</td>
                
          <td width="79" class="wr4">�µ�ʱ��</td>
                
          <td width="73" class="wr4">�ջ���</td>
          
          <td width="73" class="wr4">�ջ���ַ</td>
                
          <td width="73" class="wr4">ʵ�ʽ��</td>
                
          <td width="73" class="wr4">����״̬</td>
                
          <td width="50" class="wr4">��ѯ</td>
       </tr>
       <c:forEach var="orderMain" items="${requestScope.orderMains}">
	       <tr bgcolor="#F8FEE8" align="center"> 
	                
	          <td width="70" class="wr4">${orderMain.oid}</td>
	                
	          <td width="79" class="wr4">${orderMain.oid}</td>
	                
	          <td width="73" class="wr4">${orderMain.shouName}</td>
	          
	          <td width="73" class="wr4">${orderMain.shouAddress}</td>
	                
	          <td width="73" class="wr4">${orderMain.moneyCount}</td>
	                
	          <c:if test="${orderMain.sates == 1}">     
	          	<td width="50" class="wr4">δ����</td>
	          </c:if>
	          
	          <c:if test="${orderMain.sates == 2}">     
	          	<td width="50" class="wr4">���ڴ���...</td>
	          </c:if>
	          
	          <c:if test="${orderMain.sates == 3}">     
	          	<td width="50" class="wr4">�Ѵ���</td>
	          </c:if>
	                
	          <td width="81" class="wr4"><a href="${pageContext.request.contextPath}/ShowOrderDetailServlet?oid=${orderMain.oid}">��ϸ����</a></td>
	       </tr>
       
       </c:forEach>
     </table>
          
      <%--<table width="500" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td class="wr4">
            <div align="center">��ҳ����ҳ����ҳ��ĩҳ</div>
          </td>
        </tr>
      </table>
      --%><p>&nbsp;</p>
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