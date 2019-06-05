<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
<form action="./test_login" method="post">
<table>
<c:if test="${ sessionScope.login_id == null }">
	<tr>
		<td>ID</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="로그인">
	</tr>
</table>
</c:if>

</form>

<form action="./test_logout" method="post">
<c:if test="${ sessionScope.login_id != null }">
	<h1 style=color:red>'${ sessionScope.login_id }' 님은 현재 로그인 중입니다.</h1>
	<input type="submit" value="로그아웃">
</c:if>
</form>

</body>
</html>