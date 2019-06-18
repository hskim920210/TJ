<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공!</title>
</head>
<body>

<h1>${ login_user.user_nick } 님 환영합니다.</h1>
<p><a href="<%= request.getContextPath() %>/main.khs">메인으로</a></p>

</body>
</html>