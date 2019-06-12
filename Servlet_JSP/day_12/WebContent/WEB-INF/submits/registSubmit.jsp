<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
</head>
<body>

<c:if test="${ requestScope.result == 0 }">
	<h3 style=color:red>회원가입 실패</h3>
	<p>회원가입 도중에 문제가 발생했습니다.</p>
	<a href="<%= request.getContextPath() %>/regist.do">회원가입 페이지로 돌아가기</a>
</c:if>

<c:if test="${ requestScope.result == 1 }">
	<h3 style=color:blue>회원가입 성공 !</h3>
	<a href="<%= request.getContextPath() %>/main.do">메인 페이지로 돌아가기</a>
</c:if>

</body>
</html>