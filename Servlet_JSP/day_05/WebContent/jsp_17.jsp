<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>
</head>
<body>

<%
	String id = request.getParameter("id").trim();
	String pw = request.getParameter("password").trim();
	
	boolean isLogin = false;
	String loginMsg;
	
	if( id.equals(pw) ) {
		isLogin = true;
		loginMsg = id + " 님 환영합니다.";
		
		session.setAttribute("login_id", id);
	} else {
		loginMsg = "로그인에 실패했습니다.";
		session.removeAttribute("login_id");
	}
%>

<h2><%= loginMsg %></h2>
<h3><a href="<%=request.getContextPath()%>/jsp_16.jsp">로그인 화면으로 이동</a></h3>

</body>
</html>













