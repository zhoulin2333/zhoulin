/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2022-05-31 12:36:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.dto.HobbyDto;
import java.util.ArrayList;
import java.util.List;

public final class usersearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>???????????????</title>\r\n");
      out.write("    <script src=\"jquery-3.2.1.min.js\">\r\n");
      out.write("    </script>\r\n");
      out.write("    <script>\r\n");
      out.write("\t  function executeAjax(){\r\n");
      out.write("\t  \t\tvar sex;\r\n");
      out.write("\t\t\tif(document.getElementsByName(\"sex\")[0].checked){\r\n");
      out.write("\t\t\t\tsex = 0;\t    \t\t\t\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tsex = 1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar major = document.getElementById(\"major1\").value;\r\n");
      out.write("\t    \t$.ajax({\r\n");
      out.write("\t    \t\turl:'searchUser.do?sex=' \r\n");
      out.write("\t    \t\t\t+ sex \r\n");
      out.write("\t    \t\t\t+ '&major=' \r\n");
      out.write("\t    \t\t\t+ major+'&username='\r\n");
      out.write("\t    \t\t\t+ document.getElementById(\"username\").value,\r\n");
      out.write("\t    \t\ttype:'post',//??????????????????\r\n");
      out.write("\t    \t\tdataType:'json',//??????????????????\r\n");
      out.write("\t    \t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\",\r\n");
      out.write("\t    \t\terror:function(users){\r\n");
      out.write("\t    \t\t},\r\n");
      out.write("\t    \t\tasync:true,//????????????\r\n");
      out.write("\t    \t\tsuccess:function(users){\r\n");
      out.write("\t    \t\t\t//?????????????????????????????????\r\n");
      out.write("\t    \t\t\twhile($(\"#userTable tr\").length > 1){\r\n");
      out.write("\t    \t\t\t\t//???????????????,???????????????\r\n");
      out.write("\t    \t\t\t\t$(\"#userTable tr\").eq(1).remove();\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t\tfor(var i=0;i<users.data.length;i++){\r\n");
      out.write("\t    \t\t\t\t\r\n");
      out.write("\t    \t\t\t\tusername = users.data[i].username;\r\n");
      out.write("\t    \t\t\t\tpassword = users.data[i].password;\r\n");
      out.write("\t    \t\t\t\tif(users.data[i].sex == 0){\r\n");
      out.write("\t    \t\t\t\t\tsex = \"???\";\r\n");
      out.write("\t    \t\t\t\t}else{\r\n");
      out.write("\t    \t\t\t\t\tsex = \"???\";\r\n");
      out.write("\t    \t\t\t\t}\r\n");
      out.write("\t    \t\t\t\tvar hobby=\"\";\r\n");
      out.write("\t    \t\t\t\r\n");
      out.write("\t    \t\t\t\tfor(var j=0;j<users.data[i].hobbyList.length;j++){\r\n");
      out.write("\t    \t\t\t\t\tif(users.data[i].hobbyList[j].hobby == 0){\r\n");
      out.write("\t    \t\t\t\t\t\tif(++j<users.data[i].hobbyList.length){\r\n");
      out.write("\t    \t\t\t\t\t\t\thobby = hobby+ \"??????,\";\r\n");
      out.write("\t    \t\t\t\t\t\t\t--j;\r\n");
      out.write("\t    \t\t\t\t\t\t}else{\r\n");
      out.write("\t    \t\t\t\t\t\t\thobby = hobby+ \"??????\";\r\n");
      out.write("\t    \t\t\t\t\t\t\tbreak;\r\n");
      out.write("\t    \t\t\t\t\t\t}\r\n");
      out.write("\t    \t\t\t\t\t}else if(users.data[i].hobbyList[j].hobby == 1){\r\n");
      out.write("\t    \t\t\t\t\t\tif(++j<users.data[i].hobbyList.length){\r\n");
      out.write("\t    \t\t\t\t\t\t\thobby = hobby+ \"??????,\";\r\n");
      out.write("\t    \t\t\t\t\t\t\t--j;\r\n");
      out.write("\t    \t\t\t\t\t\t}else{\r\n");
      out.write("\t    \t\t\t\t\t\t\thobby = hobby+ \"??????\";\r\n");
      out.write("\t    \t\t\t\t\t\t\tbreak;\r\n");
      out.write("\t    \t\t\t\t\t\t}\r\n");
      out.write("\t    \t\t\t\t\t}else{\r\n");
      out.write("\t    \t\t\t\t\t\thobby = hobby + \"??????\";\r\n");
      out.write("\t    \t\t\t\t\t\tbreak;\r\n");
      out.write("\t    \t\t\t\t\t}\r\n");
      out.write("\t    \t\t\t\t}\t\r\n");
      out.write("\t    \t\t\t\tif(users.data[i].major == 0){\r\n");
      out.write("\t    \t\t\t\t\tmajor = \"????????????\";\r\n");
      out.write("\t    \t\t\t\t}else if(users.data[i].major == 1){\r\n");
      out.write("\t    \t\t\t\t\tmajor = \"??????\";\r\n");
      out.write("\t    \t\t\t\t}else{\r\n");
      out.write("\t    \t\t\t\t\tmajor = \"??????\";\r\n");
      out.write("\t    \t\t\t\t}\r\n");
      out.write("\t    \t\t\t\tintro = users.data[i].intro;\r\n");
      out.write("\t    \t\t\t\t//?????????????????????????????????\r\n");
      out.write("\t    \t\t\t\tvar bgcolor = \"\";\r\n");
      out.write("\t    \t\t\t\t//???????????????\r\n");
      out.write("\t                    if(i%2 == 0){ \r\n");
      out.write("\t                    \tbgcolors = \"#DEB887\";\r\n");
      out.write("\t                    //???????????????\r\n");
      out.write("\t                    }else{\r\n");
      out.write("\t                    \tbgcolors = \"#E9967A\";\r\n");
      out.write("\t                    }\r\n");
      out.write("\t    \t\t\t\tvar userdata=\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<tr bgcolor ='+bgcolors+'>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td><input type =\"checkbox\" id= \"check\" name =\"check\"  value =\"' + username + '\"></td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td><a href= \"userUpdateInit.do?username=' + username + '\">' + username +'</td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td>' + password + '</td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td>' + sex + '</td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td>' + hobby + '</td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td>' + major + '</td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td>' + intro + '</td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td><input type = \"button\" id=\"updateButton\" name=\"updateButton\" value = \"??????\" onclick=\"'+\"updateUser('\" + username +\"'\"+')\"/></td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'<td><input type = \"button\" id=\"deleteButton\" name=\"deleteButton\" value = \"??????\" onclick=\"'+\"deleteUser('\" + username +\"'\"+')\"/></td>'+\r\n");
      out.write("\t\t\t\t    \t\t\t\t'</tr>'\r\n");
      out.write("\t\t    \t\t\t$(\"#userTable\").append(userdata);\r\n");
      out.write("\t\t\t\t    \t\t\t\t\r\n");
      out.write("\t\t    \t\t}\r\n");
      out.write("\t    \t\t\t$(\"#userTable\").append('<tr align=\"center\" bgcolor = \"#087670\">'+\r\n");
      out.write("                                           '<td colspan=\"9\" ><input type = \"submit\" name=\"deleteall\" value=\"????????????\" onclick=\"del()\"></td>'+\r\n");
      out.write("                                           '</tr>');\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t});\r\n");
      out.write("\t    }\r\n");
      out.write("      function updateUser(username){\r\n");
      out.write("    \t  window.location = \"userUpdateInit.do?username=\"+username;\r\n");
      out.write("      }\r\n");
      out.write("      function deleteUser(username){\r\n");
      out.write("    \t  window.location = \"userDel.do?username=\"+username;\r\n");
      out.write("      }\r\n");
      out.write("      function delAll(){\r\n");
      out.write("    \t  if(document.getElementById(\"allcheck\").checked){\r\n");
      out.write("        \t  var checkBoxsObj = document.getElementsByName(\"check\");\r\n");
      out.write("        \t  for(var i= 0;i<checkBoxsObj.length;i++){\r\n");
      out.write("        \t\t  checkBoxsObj[i].checked = true ;\r\n");
      out.write("        \t  }\r\n");
      out.write("    \t  }else{\r\n");
      out.write("        \t  var checkBoxsObj = document.getElementsByName(\"check\");\r\n");
      out.write("        \t  for(var i= 0;i<checkBoxsObj.length;i++){\r\n");
      out.write("        \t\t  checkBoxsObj[i].checked = false ;\r\n");
      out.write("        \t  }\r\n");
      out.write("    \t  }\r\n");
      out.write("      }\r\n");
      out.write("      function del(){\r\n");
      out.write("    \t  document.getElementById(\"form\").action=\"delchecked.do\";\r\n");
      out.write("    \t  window.location = \"delchecked.do?\" ;\r\n");
      out.write("      }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("\t<form action=\"userSearch.do\" id=\"form\" name=\"form\">\r\n");
      out.write("\t\t??????:<input onblur=\"executeAjax()\" id=\"username\" name=\"username\">\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("                      ??????:<input type=\"radio\" name=\"sex\" checked  id=\"sex1\" value=\"0\" onblur=\"executeAjax()\">???\r\n");
      out.write("              <input type=\"radio\"  name=\"sex\" id=\"sex2\"  value=\"1\" onblur=\"executeAjax()\">???<br>\r\n");
      out.write("\t\t??????:<select id=\"major1\" name = \"major\" onblur=\"executeAjax()\">\r\n");
      out.write("\t\t    <option value=\"\"></option>\r\n");
      out.write("\t\t\t<option value=\"0\">????????????</option>\r\n");
      out.write("\t\t\t<option value=\"1\" >??????</option>\r\n");
      out.write("\t\t\t<option value=\"2\">??????</option>\r\n");
      out.write("\t\t</select><br>\t\t\r\n");
      out.write("\t\t<input type=\"submit\" value=\"??????\">\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t????????????\r\n");
      out.write("\t    <hr>\r\n");
      out.write("            ");
List<UserinfoHobbyDto> dtos =(List<UserinfoHobbyDto>)request.getAttribute("dtos");
      out.write("\r\n");
      out.write("            ");
if(dtos != null){
      out.write("\r\n");
      out.write("              <table id=\"userTable\" border = \"1\" align =\"center\" width =\"90%\">\r\n");
      out.write("                 <tr bgcolor = \"#087670\">\r\n");
      out.write("                       <td style=\"width:20\"><input type =\"checkbox\" id=\"allcheck\" name =\"allcheck\" onclick=\"delAll()\"></td>\r\n");
      out.write("\t\t               <td>??????</td>\r\n");
      out.write("\t\t               <td>??????</td>\r\n");
      out.write("\t\t               <td>??????</td>\r\n");
      out.write("\t\t               <td>??????</td>\r\n");
      out.write("\t\t               <td>??????</td>\r\n");
      out.write("\t\t               <td>??????</td>\r\n");
      out.write("\t\t               <td>??????</td>\r\n");
      out.write("\t\t               <td>??????</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("\r\n");
      out.write("              ");
 for(int line=0;line<dtos.size();line++){
                 
                   UserinfoHobbyDto dto = new UserinfoHobbyDto();
                		   dto = dtos.get(line);
                   
                 
                   
      out.write("\r\n");
      out.write("                  \r\n");
      out.write("                  ");
if(line%2 == 0){ 
      out.write("<tr bgcolor = \"#DEB887\">\r\n");
      out.write("                  ");
}else{ 
      out.write("<tr bgcolor = \"#E9967A\">");
} 
      out.write("\r\n");
      out.write("                       <td><input type =\"checkbox\" id= \"check\" name =\"check\"  value =\"");
      out.print(dto.getUsername());
      out.write("\"></td>\t\r\n");
      out.write("                       <td><a href= \"userUpdateInit.do?username=");
      out.print(dto.getUsername());
      out.write('"');
      out.write('>');
      out.print(dto.getUsername());
      out.write("</td>\r\n");
      out.write("\t                   <td>");
      out.print(dto.getPassword() );
      out.write("</td>\r\n");
      out.write("\t                   <td>\r\n");
      out.write("\t                   ");

	                   if("0".equals(dto.getSex())){
      out.write("\r\n");
      out.write("\t                \t   ");
      out.print( "???" );
      out.write("\r\n");
      out.write("\t                \t   \r\n");
      out.write("\t                   ");
 
	                   }else{
      out.write("\r\n");
      out.write("\t                       ");
      out.print("???" );
      out.write("\r\n");
      out.write("\t                \t   \r\n");
      out.write("\t                   ");

	                   } 
      out.write("\r\n");
      out.write("\t                   </td>\r\n");
      out.write("\t                   <td>\r\n");
      out.write("\t         \t\t   ");
 StringBuffer sb = new  StringBuffer ("");
	         		   
							for(HobbyDto hobbyDto : dto.getHobbyList()){ 
								
			
								sb.append(hobbyDto.getHobby() + ","); 
							} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
if(!"".equals(sb.toString())){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t   ");
if(",".equals(sb.toString().substring(sb.toString().length()-1))){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print( sb.toString().substring(0, sb.toString().length()-1).replace("0", "??????").replace("1", "??????").replace("2", "??????"));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t\t\t   ");
 }else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print( sb.toString().replace("0", "??????").replace("1", "??????").replace("2", "??????"));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t   ");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t   </td>\r\n");
      out.write("\t                   <td>\r\n");
      out.write("\t                    ");

	                   if("0".equals(dto.getMajor())){
      out.write("\r\n");
      out.write("\t                \t   ");
      out.print( "????????????" );
      out.write("\r\n");
      out.write("\t                   ");
 
	                   }else if("1".equals(dto.getMajor())){
      out.write("\r\n");
      out.write("\t                       ");
      out.print("??????" );
      out.write("\r\n");
      out.write("\t                   ");

	                   }else{  
      out.write("\r\n");
      out.write("\t                       ");
      out.print("??????");
      out.write("\r\n");
      out.write("\t                   ");

	                   }
      out.write("\r\n");
      out.write("\t                   </td>\r\n");
      out.write("\t                   <td>");
      out.print(dto.getIntro());
      out.write("</td>\r\n");
      out.write("\t                   <td style=\"width:20\"><input type = \"button\" id=\"updateButton\" name=\"updateButton\" value = \"??????\" onclick=\"updateUser('");
      out.print(dto.getUsername());
      out.write("')\"/></td>\r\n");
      out.write("                       <td style=\"width:20\"><input type = \"button\" id=\"deleteButton\" name=\"deleteButton\" value = \"??????\" onclick=\"deleteUser('");
      out.print(dto.getUsername());
      out.write("')\"/></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("              ");
}
      out.write("\r\n");
      out.write("                  <tr align=\"center\" bgcolor = \"#087670\"> \r\n");
      out.write("                       <td colspan=\"9\" ><input type = \"submit\" name=\"deleteall\" value=\"????????????\" onclick=\"del()\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("              </table>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
