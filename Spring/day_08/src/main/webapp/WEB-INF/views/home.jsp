<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome Home ~ !</title>
</head>
<body>
<h1>
	Main
</h1>

<c:if test="${ empty sessionScope.loginMember }" var="r">
	<h3><a href="<%= request.getContextPath() %>/member/regist">회원가입</a></h3>
	<h3><a href="<%= request.getContextPath() %>/member/login">로그인</a></h3>
</c:if>

<c:if test="${ not r }">
	<h3><a href="<%= request.getContextPath() %>/message/receive">받은 메세지함(${r_count})</a></h3>
	<h3><a href="<%= request.getContextPath() %>/message/send">보낸 메세지함(${s_count})</a></h3>
	<h3><a href="<%= request.getContextPath() %>/message/transform">메세지 전송</a></h3>
	<h3><a href="<%= request.getContextPath() %>/member/logout">로그아웃</a></h3>
</c:if>

</body>
</html>
