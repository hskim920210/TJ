<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>DOM 객체</title>
</head>
<body>
<h1 id="title">마우스 아웃</h1>
<a href="#" id="btn"><img src="images/btn_out.gif" alt="버튼" /></a>
<p id="img_src"></p>
<%	
	int count = 1;
	if( session.getAttribute("count") != null )
		count = (Integer)session.getAttribute("count");
	
	out.println(count);
	
	session.setAttribute("count", count + 1);
%>
<script type="text/javascript">
//<![CDATA[
   var theBtn=document.getElementById("btn");
   var s=document.getElementById("img_src");
   theBtn.onmouseover=function(){
      document.getElementById("title").innerHTML="마우스 오버";
      
      theBtn.firstChild.src="images/btn_over.gif";
      s.innerHTML=theBtn.firstChild.src;
   }

   theBtn.onmouseout=function(){
      document.getElementById("title").innerHTML="마우스 아웃";
      
      theBtn.firstChild.src="images/btn_out.gif";
      s.innerHTML=theBtn.firstChild.src;
   }
//]]>
</script>



</body>
</html>








