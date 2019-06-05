<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 !</title>
</head>
<body>
	<h2>로그인에 성공했습니다.</h2>
	<h4>'${ param.id }' 님 환영합니다. </h4>
	<c:set var="login_id" value="${ param.id }" scope="session" />
	<a href='${ pageContext.request.contextPath }/testMain.jsp'>메인으로 돌아가기</a>
</body>
</html>