<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="cn.key.entity.BookType"%>
<%@page import="cn.key.entity.BookInfo"%>
<%@page import="cn.key.dao.BookInfoDAO"%>
<html>
<head>
<style>
<!--
.wr{font-size: 12pt; line-height: 22px}
.wr1 {	FONT-SIZE: 12px; LINE-HEIGHT: 200%}
.wr2 {	FONT-SIZE: 14px; LINE-HEIGHT: 150%}
.wr3 {	FONT-SIZE: 12px}
.wr4 {	FONT-SIZE: 12px; LINE-HEIGHT: 150%}
-->
</style>
<title>�ƹ����������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
	
	<jsp:include page="fgLeft.jsp"></jsp:include>
      
    	<td width="3" bgcolor="#8F8F8F"><img src="images/point.gif" width="1" height="1"></td>
    	<%
			String typeOne = request.getAttribute("typeOne").toString();
			List<BookType> types = (List<BookType>)request.getAttribute("bookTypes");
			List<BookInfo> books = new Vector<BookInfo>();
			BookInfo book = null;
			BookInfoDAO dao = new BookInfoDAO();
		 %>
   	  <td>
    	<%for(BookType type : types) {
    		books = dao.findByTypeId(type.getBookTypeId());
    		System.out.println("books.size" + books.size());
    		if(books.size() >= 1) {
    			int i = 0;%>
    	
        <table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td width="100">&nbsp;</td>
          <td class="wr1" width="449">&nbsp;</td>
        </tr>
        <tr> 
          <td width="100" class="wr1">
            <div align="center">��<%=typeOne %> - <%=type.getBookTypeName() %>��</div>
          </td>
          <td width="449"> 
            <p>&nbsp;</p>
          </td>
        </tr>
        <tr valign="top">
        <% book = books.get(i++);  %>
          <td width="100">
            <div align="center"><a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="images/<%=book.getSmallImg()%>" width="72" height="91"></a></div>
          </td>
          <td width="449"> 
            <p><span class="wr2"><font color="#CE3431"><b><a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>��<%=book.getAuthor()%>����<br>
              </b></font></span><span class="wr4">���ۣ�<%=book.getPrice()%>Ԫ���ƹ����ۣ�<%=book.getYgcprice()%>Ԫ����<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13">����</a>
              ����<a href="<%= request.getContextPath()%>/AddFavoriteServlet?bookId=<%=book.getBookId()%>"><img src="images/c.gif" width="15" height="11">�ղؼ�</a></span></p>
            <p class="wr4"><%=book.getContext()%></p>
          </td>
        </tr>
      </table>
      <hr width="95%" align="center" size="1">
      <table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr valign="top">
        
	        <% if(books.size() >= 2) {
	        	book = books.get(i++);  %>
	            <td width="100">
	              <div align="center"><a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><img src="images/<%=book.getSmallImg()%>" width="72" height="91"></a></div>
	            </td>
	            <td width="449"> 
	              <p><span class="wr2"><font color="#CE3431"><b><a href="<%=request.getContextPath()%>/ShowBookInfoByIdServlet?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a>��<%=book.getAuthor()%>����<br>
	                </b></font></span><span class="wr4">���ۣ�<%=book.getPrice()%>Ԫ���ƹ����ۣ�<%=book.getYgcprice()%>Ԫ����<a href="<%=request.getContextPath()%>/GwcServlet?type=add&id=<%=book.getBookId()%>"><img src="<%=request.getContextPath()%>/images/xc.gif" width="15" height="13">����</a>����
	                <a href="<%= request.getContextPath()%>/AddFavoriteServlet?bookId=<%=book.getBookId()%>"><img src="images/c.gif" width="15" height="11">�ղؼ�</a></span></p>
	              <p class="wr4"><%=book.getContext()%></p>
	            </td>
	          </tr>
	          <tr valign="top">
	            <td width="100">&nbsp;</td>
	            <td class="wr1"> 
	              <p align="right"><a href="<%=request.getContextPath()%>/FindBookInfoByBookTypeServlet?bookTypeId=<%=type.getBookTypeId()%>">����...</a>&gt;&gt;&gt;</p>
	            </td>
	          </tr>
	        </table>	
	      <%}
        }else {%>
        <hr width="95%" align="center" size="1">
	    <table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr valign="top"> 
          <td width="100" class="wr1">
            <div align="left">��<%=typeOne %> - <%=type.getBookTypeName() %>��</div>
          </td>
          <td width="449"> 
            <p>&nbsp;</p>
          </td>
        </tr>
        <tr valign="middle">
          <td width="449"> 
            <p align="center"><span class="wr2"><font color="#CE3431"><b>��Ŀ¼����ʱû���鼮</b></font></span></p>
          </td>
        </tr>
      </table>
       <% }
    }%>
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