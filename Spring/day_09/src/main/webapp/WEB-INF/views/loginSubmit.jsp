<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h3>로그인을 실행했습니다.</h3>

<h4>ID : ${ member.id }</h4>
<h4>PASSWORD : ${ member.password }</h4>
<h4>NAME : ${ member.name }</h4>

<h4>REMEMBERID : ${ member.rememberID ? '저장' : '저장하지 않음' }</h4>
</body>
</html>