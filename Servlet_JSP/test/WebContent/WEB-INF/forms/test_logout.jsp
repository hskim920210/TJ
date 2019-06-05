<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 페이지</title>
</head>
<body>

<h2>'${ sessionScope.login_id }' 님 안녕히 가세요.</h2>
<c:remove var="login_id" scope="session"/>
<a href='${ pageContext.request.contextPath }/testMain.jsp'>메인으로 돌아가기</a>
</body>
</html>