<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

<!-- 좌측 상단에 표시 -->
<div id="lu"><a href="<%= request.getContextPath() %>/main.khs">KHS</a></div>

<!-- 좌측 중단에 표시 -->
<div id="lm">
<c:if test="${ empty sessionScope.login_user }" var="r">
	<h1>비회원으로 접속중입니다.</h1>
</c:if>

<c:if test="${ not r }">
<table>
	<tr>
		<td>${ login_user.user_nick } 님 환영합니다.</td>
	</tr>
	<tr>
		<td><button type="button" onclick="location.href='<%= request.getContextPath() %>/logout.khs' ">로그아웃</button></td>
		<td><button type="button" onclick="location.href='<%= request.getContextPath() %>/user_info.khs' ">회원정보 보기</button></td>
	</tr>
</table>

</c:if>

</div>


</body>
</html>