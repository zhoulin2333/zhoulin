<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ҵ��׹� ���׹��� �� �й����ȵ����ߵ��������Ż���</title>
<link href="css/front/css.css" rel="stylesheet" type="text/css" />
<link href="css/front/common.css" rel="stylesheet" type="text/css" />
<link href="css/front/css_1.css" rel="stylesheet" type="text/css" />
<link href="css/front/myegou.css" rel="stylesheet" type="text/css" />
<link href="css/front/top.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/j.js"></script>
<script type="text/javascript" src="js/districtor.js"></script>

<script type="text/javascript" language="javascript" src="/js/dateOrder.js"></script>
<script type="text/javascript" src="/js/front/StringLength.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#province").area("city");
	$("#city").area("region");
});

function isEmail(s)   
{   
var emailRegS=/^([a-zA-Z0-9_\-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
//var emailRegM=/^((([a-zA-Z0-9_\-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)([;]))+)(([a-zA-Z0-9_\-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?))$/;  
if (!emailRegS.exec(s)){
	 return false ;
}
return true  ;
}
function isNum(s)   
{   
var numRegS=/^[0-9]*$/;
//var emailRegM=/^((([a-zA-Z0-9_\-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)([;]))+)(([a-zA-Z0-9_\-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?))$/;  
if (!numRegS.exec(s)){
	 return false ;
}
return true  ;
}
function check(){
	var nickName=$("#nickName").val();
	var profession=$("#profession").val();
	var qq=$("#qq").val();
	var msn=$("#msn").val();
	var birthday=$("#birthday").val();
	var selfIntroduction=$("#selfIntroduction").val();
	var aliwangwang=$("#aliwangwang").val();
	if(!checkLength(nickName,20,"�ǳƵĳ����Ϊ20���ַ�")||!checkLength(profession,20,"ְҵ�ĳ����Ϊ20���ַ�")
			||!checkLength(qq,20,"QQ�ĳ����Ϊ20���ַ�")||!checkLength(msn,50,"msn�ĳ����Ϊ50���ַ�")
			||!checkLength(aliwangwang,20,"���������ĳ����Ϊ20���ַ�")
			||!checkLength(selfIntroduction,200,"���ҽ��ܵĳ����Ϊ200���ַ�")){
		return false;
	}
	if(birthday!=""&&!compareDate(birthday)){
		alert("����ȷ��������,���ղ��ܴ��ڽ���");
		return false;
	}
	if(qq!=''&&!isNum(qq)){
		alert("����ȷ����qq");
		return false;
	}

	if(msn!=''&&!isEmail(msn)){
		alert("����ȷ����msn");
		return false;
	}

	
	
	$("#provinceName").val("");
	$("#cityName").val("");
	$("#regionName").val("");
	var provinceName=$("#province option:selected").html();
	var cityName=$("#city option:selected").html();
	var regionName=$("#region option:selected").html();
	if(provinceName=="��ѡ��"||cityName=="��ѡ��"||regionName=="��ѡ��"){
		$("#region option[value=0]").attr("selected","true");
		$("#city option[value=0]").attr("selected","true");
		$("#province option[value=0]").attr("selected","true");
		provinceName="";
		cityName="";
		region="";
	}
	$("#provinceName").val(provinceName);
	$("#cityName").val(cityName);
	$("#regionName").val(regionName);
	return true;
}
function checkLength(value,length,message){
	  var strLen = new StringLength();
	  if(strLen.getRealLength(value)>length){
	    	alert(message);
	  		return false;
		}else{
			return true;
		}			
}
function compareDate(DateOne){
	var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ("-"));
	var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ("-")+1);
	var OneYear = DateOne.substring(0,DateOne.indexOf ("-"));
	
	var dateObj = new Date();
	var year = dateObj.getFullYear();
		var month = dateObj.getMonth()+1;
		var date = dateObj.getDate();
		
	if (Date.parse(OneMonth+"/"+OneDay+"/"+OneYear) <= Date.parse(month+"/"+date+"/"+year)){
	    
		return true;
	}else{
		
		return false;
	}
}
</script>
</head>
 
<body>
	
















	
<link href="css/index/top.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/langdingpage.js"></script>
<script type="text/javascript">document.write('<iframe id="publicheader" src="http://www.egou.com/publicheader.jsp?referer=' + escape(top.location) + '" allowTransparency="true" frameborder=0  width="100%" scrolling=no height="118px" topmargin="0" leftmargin="0"></iframe>');</script>
	
<div style="clear:both"></div>

<div class="my_jpg"></div>
<div style="clear:both"></div>
	<div class="my">
		
















	
<div class="my_l">
			<div class="my_l_1">

				<div class="my_l_1_a"></div>
				<div class="my_l_1_b">
					<div class="my_l_1_b_1">
						<div class="my_l_1_b_1_a"><a href="#" onclick="javascript:amenuAct(1);"><img src="images/front/my_9.jpg" border="0" id="abutton" /></a></div>

						<div class="my_l_1_b_1_b"><strong><span class="color">�˻�����</span></strong></div>
					</div>
					<ul class="my_l_1_b_2" id="amenu1">
						<li><div id="_a1" class="my_l_1_b_2_a"><a href="/myegoupay.do" class="color_4">��������</a></div></li>
						<li><div id="_a2" class="my_l_1_b_2_a"><a href="/myegouwealth.do" class="color_4">�ҵĲƸ�</a></div></li>
						<li><div id="_a3" class="my_l_1_b_2_a"><a href="/myegoureward.do" class="color_4">�ҵĽ���</a></div></li>
						<li><div id="_a4" class="my_l_1_b_2_a"><a href="/myegoucoin.do" class="color_4">�ҵ��ױ�</a></div></li>

						<li><div id="_a5" class="my_l_1_b_2_a"><a href="/myegoucoinhistory.do" class="color_4">�ױҶһ���ʷ</a></div></li>
					</ul>
					<div style="clear:both"></div>
					<div class="my_l_1_b_1">
						<div class="my_l_1_b_1_a"><a href="#" onclick="javascript:pmenuAct(1);"><img src="images/front/my_9.jpg" border="0" id="pbutton" /></a></div>
						<div class="my_l_1_b_1_b"><strong><span class="color">���ﷵ��</span></strong></div>
					</div>
					<ul class="my_l_1_b_2" id="pmenu1">

						<li><div id="_a6" class="my_l_1_b_2_a"><a href="/myegousubmitorder.do" class="color_4">�ύ����</a></div></li>
						<li><div id="_a7" class="my_l_1_b_2_a"><a href="/myegouorder.do" class="color_4">�ҵĶ���</a></div></li>
						<li><div id="_a8" class="my_l_1_b_2_a"><a href="/myegoutracearticle.do" class="color_4">��Ʒ׷��</a></div></li>
						<li><div id="_a9" class="my_l_1_b_2_a"><a href="/myegoutraceorder.do" class="color_4">��ʱ��ѯ</a></div></li>
					</ul>
					<div style="clear:both"></div>
					<div class="my_l_1_b_1">

						<div class="my_l_1_b_1_a"><a href="#" onclick="javascript:qmenuAct(1);"><img src="images/front/my_9.jpg" border="0" id="qbutton" /></a></div>
						<div class="my_l_1_b_1_b"><strong><span class="color">������Ϣ</span></strong></div>
					</div>
					<ul class="my_l_1_b_2" id="qmenu1"><!--

                        <li><div id="_a13" class="my_l_1_b_2_a"><a href="http://bbs.egou.com/memcp.php" class="color_4">��������</a></div></li>   
						--><li><div id="_a13" class="my_l_1_b_2_a"><a href="/myegouedituser.do" class="color_4">��������</a></div></li>
						<li><div id="_a11" class="my_l_1_b_2_a"><a href="/myegoupassword.do" class="color_4">�������</a></div></li>
						<li><div id="_a10" class="my_l_1_b_2_a"><a href="/myegouuseraddress.do" class="color_4">�ջ���ַ</a></div></li>
					</ul>

					<div style="clear:both"></div>
					<div class="my_l_1_b_1">
						<div class="my_l_1_b_1_a"><a href="#" onclick="javascript:omenuAct(1);"><img src="images/front/my_9.jpg" border="0" id="obutton" /></a></div>

						<div class="my_l_1_b_1_b"><strong><span class="color">��ɫ����</span></strong></div>
					</div>
					<ul class="my_l_1_b_2" id="omenu1">
						<li><div id="_a12" class="my_l_1_b_2_a"><a href="/myegouexpresslist.do" class="color_4">��ݲ�ѯ</a></div></li>

						<li><div class="my_l_1_b_2_a"><a href="/union.html" class="color_4">��׬����</a></div></li>
						<li><div class="my_l_1_b_2_a"><a href="http://caipiao.egou.com" class="color_4">���Ʊ</a></div></li>
					</ul>

					<div style="clear:both"></div>
				</div>
			</div>
		</div>

<script type="text/javascript">
	var menuId=13;
	if(menuId!=-1){
		var html=$("#_a"+menuId+" a").html();
		$("#_a"+menuId).html(html);
		document.getElementById("_a"+menuId).className="my_l_1_b_2_a my_l_1_b_2_bj";
		//$("#_a"+menuId).css("my_l_1_b_2_a my_l_1_b_2_bj");
	}
	
</script>		

<script type="text/javascript">
	function amenuAct(mid)
	{
	var stat;
	stat=document.getElementById("amenu"+mid).style.display;
	if (stat=="none") {
		document.getElementById("amenu"+mid).style.display='block';
		document.getElementById("abutton").src='/images/front/my_9.jpg';
	} else {
		document.getElementById("amenu"+mid).style.display='none';
		document.getElementById("abutton").src='/images/front/my_10.jpg';
	}
	return;

	}

	
	function pmenuAct(mid)
	{
	var stat;
	stat=document.getElementById("pmenu"+mid).style.display;
	if (stat=="none") {
		document.getElementById("pmenu"+mid).style.display='block';
		document.getElementById("pbutton").src='/images/front/my_9.jpg';
	} else {
		document.getElementById("pmenu"+mid).style.display='none';
		document.getElementById("pbutton").src='/images/front/my_10.jpg';
	}
	return;

	}
	
	function qmenuAct(mid)
	{
	var stat;
	stat=document.getElementById("qmenu"+mid).style.display;
	if (stat=="none") {
		document.getElementById("qmenu"+mid).style.display='block';
		document.getElementById("qbutton").src='/images/front/my_9.jpg';
	} else {
		document.getElementById("qmenu"+mid).style.display='none';
		document.getElementById("qbutton").src='/images/front/my_10.jpg';
	}
	return;

	}
	
	function omenuAct(mid)
	{
	var stat;
	stat=document.getElementById("omenu"+mid).style.display;
	if (stat=="none") {
		document.getElementById("omenu"+mid).style.display='block';
		document.getElementById("obutton").src='/images/front/my_9.jpg';
	} else {
		document.getElementById("omenu"+mid).style.display='none';
		document.getElementById("obutton").src='/images/front/my_10.jpg';
	}
	return;

	}
</script>
	  <div class="my_r_a">
	  	<div class="my_r_a_1">��������</div>
		<div class="my_r_a_2"></div>
		<div class="my_r_a_3">
		  <table width="768" cellspacing="0" cellpadding="0">
            <tr>

              <td colspan="2" valign="bottom"><div class="my_r_a_14"><img width="100px" src="http://ucenter.egou.com/avatar.php?uid=963590&size=middle" /></div>                </td>
              <td width="77" valign="bottom"><div class="my_r_a_15"><img width="50px" src="http://ucenter.egou.com/avatar.php?uid=963590&size=small" /></div></td>
              <td width="560" valign="bottom"><div class="my_r_a_16"><img width="25px" src="http://ucenter.egou.com/avatar.php?uid=963590&size=small" /></div></td>
            </tr>
            <tr>
              <td width="102" height="45" align="center"><input type="button" name="Submit22" value="�޸�ͷ��" class="button_28" onclick="window.open('http://bbs.egou.com/memcp.php');" /></td>
              <td width="27" height="45">&nbsp;</td>
              <td height="45" colspan="2">&nbsp;</td>

            </tr>
          </table>
		</div>
		<div class="my_r_a_3">
		<form method="post" id="form" onsubmit="return check()"> 
		  <table width="768" cellspacing="0" cellpadding="0">
            <tr>
              <td width="70" height="30" align="right">�û���:</td>
              <td height="30" colspan="2">hengyufxh1</td>

              <td width="57" height="30" align="right">�ǳ�:</td>
              <td width="125" height="30">
              
              <input type="text" id="nickName" name="nickName" value="" class="input_12" />
              
              
              </td>
              <td width="39" height="30">&nbsp;</td>
              <td width="36" height="30">&nbsp;</td>
              <td width="36" height="30">&nbsp;</td>
              <td width="36" height="30">&nbsp;</td>

              <td width="45" height="30">&nbsp;</td>
            </tr>
            <tr>
              <td height="30" align="right">�Ա�:</td>
              <td height="30" colspan="2">
                
                <input type="radio" name="sex" value="male" /> ��
                <input type="radio" name="sex" value="female"  />Ů</td>
                
              <td height="30" align="right">��������:</td>

              <td height="30" colspan="4">
				 
					<input  maxlength="10" class="input_12" id="birthday" type="text"  name="birthday" onfocus="setday(this)" value=""/>
		            
				
			</td>
            </tr>
            
            <tr>
              <td height="30" align="right">����״̬:</td>
              <td height="30" colspan="2">
              
			  	<select name="loveStatus" class="input_15">

			  	  <option value="0">����</option>
			  	  <option value="1" >�ǵ���</option>
			  	  <option value="2" >����</option>
			  	</select>			
			  	
			  	</td>
              <td height="30" align="right">Ѫ��:</td>
              <td height="30" colspan="6">

               
				  <select name="bloodType" class="input_15">
					<option value="0">����</option>
					<option value="1" >
						A
					</option>
					<option value="2" >
						B
					</option>
					<option value="3" >

						AB
					</option>
					<option value="4" >
						O
					</option>
				  </select>			  
				  
				  </td>
            </tr>
            
            <tr>
              <td height="30" align="right">�����̶�:</td>

              <td height="30" colspan="2">
              
	           <select name="eduDegree" class="input_15">
                <option value="0">��ѡ��</option>
                <option value="1" >Сѧ</option>
                <option value="2"  >����</option>
				<option value="3" >��ר/��У</option>
				<option value="4" >����</option>

				<option value="5" >��ר</option>
				<option value="6" >����</option>
				<option value="7" >˶ʿ</option>
				<option value="8" >��ʿ</option>
				<option value="9" >��ʿ��</option>
              </select>

              
              </td>
              <td height="30" align="right">ְҵ:</td>
              <td height="30" colspan="6">
              
              <input type="text" id="profession" name="profession" value="" class="input_12" />
              
              </td>
            </tr>
           
            <tr>
              <td height="30" align="right">���ڳ���:</td>

              <td width="125" height="30">
               <input type="hidden" id="provinceName" name="provinceName"/>
               
			  	 <select name="provinceId" id="province" class="input_15">
			         <option value="0">��ѡ�� </option>
						
							<option value="10000"  >����</option>
					   
							<option value="20000"  >�Ϻ�</option>
					   
							<option value="30000"  >����</option>

					   
							<option value="40000"  >���</option>
					   
							<option value="50000"  >�ӱ�</option>
					   
							<option value="60000"  >ɽ��</option>
					   
							<option value="70000"  >���ɹ�</option>
					   
							<option value="80000"  >����</option>
					   
							<option value="90000"  >����</option>

					   
							<option value="100000"  >������</option>
					   
							<option value="110000"  >����</option>
					   
							<option value="120000"  >�㽭</option>
					   
							<option value="130000"  >����</option>
					   
							<option value="140000"  >����</option>
					   
							<option value="150000"  >����</option>

					   
							<option value="160000"  >ɽ��</option>
					   
							<option value="170000"  >����</option>
					   
							<option value="180000"  >����</option>
					   
							<option value="190000"  >����</option>
					   
							<option value="200000"  >�㶫</option>
					   
							<option value="210000"  >����</option>

					   
							<option value="220000"  >����</option>
					   
							<option value="230000"  >����</option>
					   
							<option value="240000"  >�Ĵ�</option>
					   
							<option value="250000"  >����</option>
					   
							<option value="260000"  >����</option>
					   
							<option value="270000"  >����</option>

					   
							<option value="280000"  >����</option>
					   
							<option value="290000"  >����</option>
					   
							<option value="300000"  >�½�</option>
					   
							<option value="310000"  >�ຣ</option>
					   
							<option value="320000"  >̨��</option>
					   
							<option value="330000"  >���</option>

					   
							<option value="340000"  >����</option>
					   
			       </select>
			       
			       
			       </td>
              <td width="197" height="30">
              <input type="hidden" id="cityName" name="cityName"/>
              
			  	 <select name="cityId" id="city" class="input_15">
			       		<option value="0">��ѡ�� </option>
			       		
			       </select>

			       
			       <input type="hidden" id="regionName" name="regionName"/>
			       
			     <select name="regionId" id="region" class="input_15">
			       <option value="0">��ѡ�� </option>
			       		
			       </select>
			       
			   </td>
              <td height="30" align="right">����:</td>
              <td height="30" colspan="6">
               
				  <select name="hair" class="input_15">

				      <option value="0">��ѡ��</option>
					  <option value="1" >����</option>
					  <option value="2" >�����</option>
					  <option value="3" >����</option>
					  <option value="4" >����</option>
					  <option value="5" >������</option>

				  </select>			  
				  
				  </td>
            </tr>
             
            <tr>
              <td height="30" align="right">QQ����:</td>
              <td height="30">
              
              <input type="text" id="qq" name="qq" value="" class="input_12" />
              
              </td>
              <td height="30">

                
              <input type="checkbox" name="qqOnlyFriendShow" value="1" />
              
              �����ѿɼ�</td>
              <td height="30" align="right">MSN:</td>
              <td height="30">
              
              <input type="text" id="msn" name="msn" value="" class="input_12" />
              
              </td>
              <td height="30" colspan="5">
              
              <input type="checkbox" name="msnOnlyFriendShow" value="1" />

              
                                    �����ѿɼ�</td>
            </tr>
            
            <tr>
              <td height="30" align="right">��������:</td>
              <td height="30">
              
              <input type="text" id="aliwangwang" name="aliwangwang" value="" class="input_12" />
              
              </td>
              <td height="30"> 
              <input type="checkbox" name="aliOnlyFriendShow" value="1" />

               �����ѿɼ�</td>
              <td height="30" align="right">Email:</td>
              <td height="30">
              
            <input type="text"  readonly="readonly" value="hengyufxh1@163.com" class="input_12" />
               
              </td>
              <td height="30" colspan="5"> 
              <input type="checkbox" name="emailOnlyFriendShow" value="1" />
               �����ѿɼ�</td>

            </tr>
           
           <tr>
              <td height="30" align="right">���ҽ���:</td>
              <td height="30" colspan="9"><span class="color_19">200�ֽ�����</span></td>
            </tr>
            <tr>
              <td align="right">&nbsp;</td>
              <td colspan="9">

              
              <textarea name="selfIntroduction" id="selfIntroduction" class="input_54"></textarea>
              
              </td>
            </tr>
      
            <tr>
              <td height="45" align="right">&nbsp;</td>
              <td height="45" colspan="9"><input type="submit" name="Submit2" value="��������" class="button_28" /></td>
            </tr>
          </table>

          </form>
		</div>
	  </div>
	</div>
	<div style="clear:both"></div>
	<div class="Bottom">
			

<div class="Bottom">
		<div class="Bottom_1" style="margin-top:5px"></div>
		<div class="Bottom_2">

		  <table width="950" cellspacing="0" cellpadding="0">
			<tr>
			  <td colspan="3" align="center"><a href="/help/aboutegou.html" target="_blank" class="color">�����׹�</a> | <a href="/help/mediumreported.html" target="_blank" class="color">ý�屨��</a> | <a href="/help/loveletter.html"  class="color_1">�׹�����</a> | <a href="/help/advertisement.html" target="_blank" class="color">������</a> | <a href="http://bbs.egou.com/thread.php?fid=16" target="_blank" class="color">��������</a> | <a href="/help/" target="_blank" class="color">��վ����</a> | <a href="/help/sitemap.html" target="_blank" class="color">��վ��ͼ</a> | <a href="/help/links.html" target="_blank" class="color">��������</a> |
	   <a href="/help/contactus.html" target="_blank" class="color">��ϵ����</a></td>

			  </tr>
			<tr>
			  <td width="250"></td>
			  <td width="389" align="center"><span style="color:#666666">Copyright &copy; 2004-2010 by   www.egou.com all rights reserved<br />
				<a href="http://www.emar.com.cn" target="_blank" class="color_2">��������</a> ������վ<a href="http://www.miibeian.gov.cn/" target="_blank" class="color_2">��ICP֤080025��</a> </span></td>

			  <td width="309" height="60" align="left" valign="middle"></td>
			</tr>
		  </table>
 		</div>
	</div>

	<script language="javascript" type="text/javascript">
		var eid=getUrlValue('eid');
		var yid=getUrlValue('yid');
		var keyword=getUrlValue('keyword');
		var cookieName='';
		var cookieValue='';
		if(keyword!=''){
			if(eid!=''){
				cookieName='EqifaKeyword';
				cookieValue='_eid_'+eid+'_'+keyword;
				cookieCallback(cookieValue);	
				//encoder.encoder(cookieValue,cookieCallback);
			}else if(yid!=''){
				cookieName='YiqifaKeyword';
				cookieValue='_yid_'+yid+'_'+keyword;
				cookieCallback(cookieValue);
				//encoder.encoder(cookieValue,cookieCallback);
			}
		}
		function cookieCallback(msg){
			cookieValue=msg;
			var name=cookieName;
			var value=cookieValue;
			var expires=1;
			var path="/";
			var domain=".egou.com";
			var secure="";
			var today = new Date();    
		  	today.setTime( today.getTime() );    
		   	if (expires) {     
		       expires = expires * 1000 * 60 * 30;     
		   	}
		    var expires_date = new Date( today.getTime() + (expires));   
		    document.cookie = name+'='+(value)+((expires) ? ';expires='+expires_date.toGMTString() : '')+((path) ? ';path=' + path : '') +((domain) ? ';domain=' + domain : '')+((secure) ? ';secure' : ''); 
		}
		
		
		function getUrlValue(qs){
	        var s = location.href;
	        s = s.replace("?","?&").split("&");
	        var re = "";
	        for(i=0;i<s.length;i++){
	           if(s[i].indexOf(qs+"=")==0){
	             re = s[i].replace(qs+"=","");
	             break;
	            }
	        }
	        return re;
		}
		 
	</script>
	
	<!-- ����sem��� -->
	<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-12246903-1']);
  _gaq.push(['_setDomainName', '.egou.com']);
  _gaq.push(['_trackPageview']);

  _gaq.push(['_setAccount', 'UA-1267821-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();



</script>
<script type="text/javascript">

var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F977ed62600436aca38f88304752ba8c4' type='text/javascript'%3E%3C/script%3E"));
</script>

	

	</div>
</body>
</html>
 


