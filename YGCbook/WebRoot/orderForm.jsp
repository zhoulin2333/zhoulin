<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="cn.key.gwc.Gwc"%>
<%@page import="cn.key.gwc.GwcItem"%>

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
<title>������ϸ��Ϣ - �ƹ����������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<jsp:include page="fgLeft.jsp"></jsp:include>
<%
	float ygcSum = 0;
	float sum = 0;
 %>
 <td> 
<table width="662" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td> 
      <div align="center" class="wr4"><b><font color="#BA6119">���Ķ�����ϸ��Ϣ</font></b></div>
    </td>
  </tr>
  <tr>
    <td><img src="images/hb10.gif" width="662" height="41"></td>
  </tr>
  <tr> 
    <td background="images/hb01.gif" bgcolor="#FEFFEF"> 
      <table width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table>
       <%Gwc gwc = (Gwc)session.getAttribute("gwc");
	        if(gwc == null || gwc.getItems().size() == 0) {%>
	        	<p align="center" class="wr4"><font color="#FF0000">����û�й�����Ʒ����<a href="<%=request.getContextPath()%>/FindBookTypeServlet">����</a>����</font></p>
      		<%}else{
				Collection<GwcItem> items = gwc.getItems();%> 
				
      <table width="600" border="0" cellspacing="1" cellpadding="5" align="center" dwcopytype="CopyTableRow" bgcolor="#000000">
        <tr align="center" bgcolor="#FEFFEF"> 
          <td class="wr4" width="30">���</td>
          <td class="wr4" width="145">����</td>
          <td class="wr4" width="70">����</td>
          <td class="wr4" width="80">ԭ��</td>
          <td class="wr4" width="80">�ƹ�����</td>
          <td class="wr4" width="80">С��</td>
          <td class="wr4" width="80">��ʡ</td>
          <td class="wr4" width="35">ɾ��</td>
        </tr>
        
        <%for(GwcItem item : items) {
	        	ygcSum += item.getYgcPrice() * item.getNum();
	        	sum += item.getPrice() * item.getNum();
	        	%>
	     <tr bgcolor="#FEFFEF"> 
          <td class="wr4" width="30"><%=item.getBookId()%></td>
          <td class="wr4" width="145"><%=item.getBookName()%></td>
          <td class="wr4" width="70"><%=item.getNum()%></td>
          <td class="wr4" width="80"><%=item.getPrice()%></td>
          <td class="wr4" width="80"><%=item.getYgcPrice()%></td>
          <td class="wr4" width="80"><%=(item.getYgcPrice() * item.getNum())%></td>
          <td class="wr4" width="80"><%=(item.getPrice() * item.getNum() - item.getYgcPrice() * item.getNum())%></td>
          <td class="wr4" width="35"><a href="<%=request.getContextPath()%>/GwcServlet?type=delete&id=<%=item.getBookId()%>" onclick="return isDelete('<%=item.getBookName() %>');">ɾ��</a></td>
        </tr>
	    <%} %>
      </table>
      <table width="600" border="0" cellspacing="0" cellpadding="5" align="center">
        <tr> 
          <td class="wr4"> 
            <p>�ƹ������ܼƣ�<font color="#FF0000"><%=ygcSum%></font> Ԫ�������ܼƽ�ʡ�ˣ�<font color="#FF0000"><%=(sum-ygcSum)%></font> 
              Ԫ</p>
          </td>
          <td class="wr4"><font color="red"><a href="${pageContext.request.contextPath}/gwc.jsp" onclick="return cancel();">ȡ������</a></font></td>
        </tr>
        <tr> 
          <td class="wr4" colspan="2"> 
            <hr width="100%" size="1" noshade>
          </td>
        </tr>
      </table>
      <table width="600" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td class="wr1" colspan="2">&nbsp;</td>
        </tr>
        <tr align="center">
          <td class="wr1" colspan="2" align="center"><font color="#FF0000">����ȷ��д������Ϣ���Ա����Ǽ�ʱ׼ȷ�ش�������*��Ϊ������Ϣ����</font></td>
        </tr>
        <tr> 
          <td class="wr1" colspan="2" align="right" width="70%">
          
            <form name="form1" method="post" action="<%= request.getContextPath() %>/OrderServlet" >
              <c:if test="${empty requestScope.customerDetail}" var="re">
				  <b>�ջ�������</b>�� 
	              <input type="text" name="name">*<br>
	              <b>E-mail</b>�� 
	              <input type="text" name="email">*<br>
	              <b>��ϵ�绰</b>�� 
	              <input type="text" name="tel">*<br>
	              <b>�ջ�����ϸͨѶ��ַ</b>��
	              <textarea name="address" rows="4" cols="19"></textarea>*<br>
	              <b>QQ</b>�� 
	              <input type="text" name="qq"><br>
              </c:if>
			  <c:if test="${!re}">
	              <b>�ջ�������</b>:
	              <input type="text" name="name" value="${customerDetail.realname}">*<br>
	              <b>E-mail</b>�� 
	              <input type="text" name="email">*<br>
	              <b>��ϵ�绰</b>�� 
	              <input type="text" name="tel" value="${customerDetail.tel}">*<br>
	              <b>�ջ�����ϸͨѶ��ַ</b>��
	              <textarea name="address" rows="4" cols="19">${customerDetail.address}</textarea>*<br>
	              <b>QQ</b>�� 
	              <input type="text" name="qq" value="${customerDetail.qq}"><br>
              </c:if>
              <input type="submit" name="submit" value="ȷ��֧��">&nbsp;&nbsp;
              <input type="reset" name="reset" value="����">
            </form>
          </td>
          <td class="wr1" colspan="2" align="right" >
            &nbsp;&nbsp;
          </td>
        </tr>
      </table>
      <table width="600" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr> 
          <td colspan="2"> 
            <hr width="100%" size="1" noshade>
          </td>
        </tr>
      </table>
       <%} %>
    </td>
  </tr>
  <tr> 
    <td><img src="images/hb05.gif" width="662" height="10"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td> 
      <div align="center"> 
        <p><img src="images/daodu36.gif" width="593" height="58" alt="�����"></p>
        <p class="wr1">������ | Ѱ��Ǽ� | �����Ѷ | �Ļ�ɳ�� | ���ƽ̨<br>
          ������� | ����� | ��ϵ����</p>
      </div>
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
<script type="text/javascript">
	function isDelete(bookName) {
		return confirm("��ȷ��Ҫɾ�� ["+bookName+"] ��");
	}
	function isClear() {
		return confirm("��ȷ��Ҫ��չ��ﳵ��");
	}
	function changeNum(text,id){
		if(isNaN(text.value)) {
			alert("��Ʒ��������Ϊ���֣�");
			return;
		}
		var num = parseInt(text.value);
		if(num < 1) {
			alert("��Ʒ��������С��1");
			return;
		}
		var url = "<%=request.getContextPath()%>/GwcServlet?type=updateNum&id=" + id + "&num=" + num;
		window.location = url;
	}
	function cancel(){
		return confirm("��ȷ��Ҫȡ��������");
	}
</script>
</html>
