<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 화면</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/auth/logout.do" method="post">
	
	<h3>'${login_member.name}' 님 로그아웃 하시겠습니까?</h3>
	<input type="submit" value="로그아웃">

</form>

<p><a href='${pageContext.request.contextPath}/main.do'>메인화면으로 이동</a></p>

</body>
</html>















