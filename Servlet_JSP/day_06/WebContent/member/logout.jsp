<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 결과</title>
</head>
<body>

<%
	// 세션을 확인하여 로그인 정보를 지운다.
	String id = (String)session.getAttribute("login_id");
	String name = (String)session.getAttribute("login_name");
	
	session.removeAttribute("login_id");
	session.removeAttribute("login_name");
	
	Integer count = Integer.parseInt((String)application.getAttribute("count"));
	application.setAttribute("count", "" + (count-1));
%>

<h3><%= name %>님의 로그아웃 요청이 처리되었습니다.</h3>
<input type = "button" value = "메인으로" onclick = "location.href='<%= request.getContextPath() %>/member/main.jsp'">

</body>
</html>