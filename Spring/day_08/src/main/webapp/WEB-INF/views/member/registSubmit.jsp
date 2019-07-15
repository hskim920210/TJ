<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

<c:if test="${ regist_result }">
	<h3>회원가입이 정상적으로 처리되었습니다.</h3>
	<p><a href="<%= request.getContextPath() %>/">메인으로 돌아가기</a></p>
</c:if>

<c:if test="${ not regist_result }">
	<h3>회원가입에 실패했습니다. 관리자에게 문의하세요.</h3>
	<p><a href="<%= request.getContextPath() %>/member/regist">회원가입 페이지로 돌아가기</a></p>
	<p><a href="<%= request.getContextPath() %>/">메인으로 돌아가기</a></p>
</c:if>

</body>
</html>