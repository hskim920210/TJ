<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
<h2>약관 동의 결과 : ${ member.agree }</h2>
<h2>이름 : ${ member.name }</h2>
<h2>나이 : ${ member.age }</h2>
<%--
<p>결과 : ${ not empty param.agree ? param.agree : false }</p>
--%>


</body>
</html>