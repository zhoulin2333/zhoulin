<%@page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="cn.key.entity.BookInfo"%>
<%@page import="cn.key.entity.BookDiscuss"%>
<%@page import="cn.key.entity.CustomerInfo"%>
<%@page import="cn.key.dao.CustomerInfoDAO"%>
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
<title>ͼ����ϸ��Ϣ - �ƹ����������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

	<jsp:include page="fgLeft.jsp"></jsp:include>
      
    <%
		BookInfo book = (BookInfo)request.getAttribute("book") ;
		List<BookDiscuss> dis = (List<BookDiscuss>)request.getAttribute("bookDiscuss");
		CustomerInfo customer = null;
		CustomerInfoDAO dao = new CustomerInfoDAO();
		int size = 0;
	%>
    <td> 
      <table width="519" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td class="wr4">
            
          </td>
        </tr>
        <tr>
          <td class="wr4">
            <p><img src="images/hb11.gif" width="519" height="40"></p>
            </td>
        </tr>
        <tr>
          <td class="wr1" background="images/hb02.gif" bgcolor="#FFFBEF"> 
            <table width="500" border="0" cellspacing="0" cellpadding="5" align="center">
              <tr valign="top"> 
                <td width="160"><img src="images/<%=book.getBigImg() %>" width="150" height="219"></td>
          <td class="wr2"> 
                  <p><font color="#9C0000"><b>�� <%=book.getBookName() %>�����ߣ�<%=book.getAuthor() %>��</b></font></p>
            <table width="100%" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                      <td class="wr2"><font face="����_GB2312">����<%=book.getContext() %></font></td>
                    </tr>
                    <tr> 
                      <td class="wr1">���ۣ�<font color="#FF0000"><%=book.getPrice()%></font> Ԫ���ƹ����ۣ�<font color="#FF0000"><%=book.getYgcprice() %>
                        </font>Ԫ����
                        <a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="images/xc.gif" width="15" height="13">����</a>��
                        <a href="<%= request.getContextPath()%>/AddFavoriteServlet?bookId=<%=book.getBookId()%>"><img src="images/c.gif" width="15" height="11">�ղؼ�</a></td>
                    </tr>
                  </table>      <table width="100%" border="0" cellspacing="0" cellpadding="5">
                    <tr valign="top"> 
                      <td width="40%" class="wr4">�����ߡ�<%=book.getAuthor()%></td>
                      <td width="60%" class="wr4">�������硿<%=book.getPbName() %></td>
                    </tr>
                    <tr valign="top"> 
                      <td width="60%" class="wr4">����Ρ�<%=book.getPbdate() %><br>
                        ��ISBN�š�7-220-06312-1//<br>
                        ��װ֡�� ƽװ<br>
                        �����״���� �� </td>
                    </tr>
                  </table>
          </td>
        </tr>
      </table>
      <hr width="95%" size="1" align="center">
      <table width="95%" border="0" cellspacing="0" cellpadding="5" align="center">
        <tr>
          <td class="wr4"> 
                  <p><font color="#9C0000">�����ݼ�顿</font><br>
              <font face="����_GB2312">����<%=book.getContext()%></font>
            </p>
            </td>
        </tr>
      </table>
      <hr width="95%" size="1" align="center">
            <table width="95%" border="0" cellspacing="0" cellpadding="5" align="center">
              <tr> 
                <td class="wr1"><font color="#9C0000">�������������ۡ�</font></td>
              </tr>
              <% if(dis.size() == 0) {%>
              		<tr> 
	                <td class="wr1"> 
	                  <p>���黹û������</p>
	                  </td>
	              </tr>
              <%} else{
            	  if(dis.size() == 1) {
              		size = 1;
            	  }else{
            		size = 2;
            	  }
            	  	for(int i = 0; i < size; i++) {
            	  		BookDiscuss di = dis.get(i);
                  		customer = dao.findById(di.getCustomerId());	
                  		%>
                  	<tr> 
    	                <td class="wr1"> 
    	                  <p>���⣺�ö������һ������������ߣ�<%=customer.getCustomerName()%>�������������ڣ�<%=di.getWriteData()%><br>
    	                    �Ա�������ۣ�������<br>
    	                    ���ݣ�</p>
    	                  <p align="center"><%=di.getContext() %></p>
    	                  <hr width="99%" size="1" align="center">
    	                  </td>
    	                  
    	              </tr>
    	              
            	<%}
            	}%>
              <tr> 
                <td class="wr1"> 
                  <p align="center">&lt;&lt;<a href="${pageContext.request.contextPath }/ShowAllDiscussServlet?bookId=${requestScope.book.bookId}&bookName=${requestScope.book.bookName}">���ȫ������</a> &gt;&gt;����&lt;&lt; <a href="${pageContext.request.contextPath }/WriteDiscussServlet?bookId=${requestScope.book.bookId}&bookName=${requestScope.book.bookName}">�������� </a>&gt;&gt;</p>
                </td>
              </tr>
            </table>
      <hr width="95%" size="1" align="center">
          </td>
        </tr>
        <tr>
          <td class="wr4"><img src="images/hb03.gif" width="519" height="9"></td>
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