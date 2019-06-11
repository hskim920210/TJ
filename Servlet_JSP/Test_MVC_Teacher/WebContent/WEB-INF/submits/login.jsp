<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 화면</title>
</head>
<body>

<c:if test="${ requestScope.isLogin }" var="result" >
	<h3>로그인에 성공했습니다</h3>
</c:if>

<c:if test="${ not result }">
	<h3>로그인에 실패했습니다</h3>
	<h4>아이디와 패스워드를 확인하세요</h4>
</c:if>

<p><a href='<%= request.getContextPath() %>/main.do'>메인화면으로 이동</a></p>

</body>
</html>






