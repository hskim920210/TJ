<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증 에러 발생</title>
</head>
<body>

<h3>로그인이 필요한 서비스에 접근하였습니다.</h3>

<h3>로그인이 후 접속해 주세요.</h3>

<h3><a href='<%= request.getContextPath() %>/member_login'>로그인으로 이동</a></h3>


</body>
</html>