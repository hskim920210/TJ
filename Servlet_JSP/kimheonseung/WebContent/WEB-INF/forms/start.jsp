<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작 페이지</title>
</head>
<body>


<!-- 중단에 표시 -->
<div id="m">
<form id="loginform" action="<%= request.getContextPath() %>/login.khs" method="post">
	<caption>로그인 하여 시작하기</caption>
	<table name="login_table">
		<tr>
			<td>ID</td>
			<td><input type="text" name="user_id" value="${ not empty cookie.save_user_id ? cookie.save_user_id.value : '' }" required></td>
			<td>
			<label>
			<input type="checkbox" name="save_user_id"
			${ not empty cookie.save_user_id ? 'checked' : '' } value="true">(ID 저장)
			</label>
			</td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="user_pw" required></td>
		</tr>
		<tr>
			<td><input type="submit" value="로그인"></td>
			<td><button type="button" onclick="location.href='<%= request.getContextPath() %>/regist.khs' ">회원가입</button></td>
		</tr>
		<tr>
			<td colspan="2"><a href="<%= request.getContextPath() %>/main.khs">비회원으로 시작하기</a></td>
		</tr>
	</table>
</form>
</div>


</body>
</html>