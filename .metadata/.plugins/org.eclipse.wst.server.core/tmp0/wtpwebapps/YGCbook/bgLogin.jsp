<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>��̨����Ա��½--�ƹ���</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/invalid.css" type="text/css" media="screen" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/scripts/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/scripts/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/scripts/facebox.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/scripts/jquery.wysiwyg.js"></script>
</head>
<body id="login">
<div id="login-wrapper" class="png_bg" align="center">
  <div id="login-top">
    <h1>����Ա��½</h1>
    <a href=""><img id="logo" src="resources/images/logo.png" alt="Simpla Admin logo" /></a> </div>
  <div id="login-content">
    <form action="<%=request.getContextPath()%>/SysAdminServlet" method="post">
      <div class="notification" align="center" >
        <div>�ƹ�����̨��½ </div>
      </div>
      <p>
        <label>�û�����</label>
        <input name="name" class="text-input" type="text" />
      </p>
      <div class="clear"></div>
      <p>
        <label>���룺</label>
        <input name="pwd" class="text-input" type="password" />
      </p>
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" />
       	 ��ס����
      </p>
         
      <% if(session.getAttribute("tishi") != null) {%>
	      <div class="clear"></div>
	      <p align="center">
	      <font color="red">�û������������</font>
	      </p>
      <%
      	session.removeAttribute("tishi"); 
      } %>
      <div class="clear"></div>
      <p>
        <input class="button" type="submit" value="����Ա��½" />
      </p>
    </form>
  </div>
  <!-- End #login-content -->
</div>
<!-- End #login-wrapper -->
</body>
</html>
