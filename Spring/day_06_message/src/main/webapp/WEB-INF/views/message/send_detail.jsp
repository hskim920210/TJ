<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 메세지 서비스 제공 사이트</title>
</head>
<body>

<!-- 이파일은 사용안함 -->
<table border="1">
	<tr>
		<td>받는이</td>
		<td>내용</td>
		<td>보낸시간</td>
		<td>읽은시간</td>
	</tr>
	<tr>
		<td>${ msg.receiver }</td>
		<td>${ msg.content }</td>
		<td>${ msg.send_time }</td>
		<td>${ msg.receive_time }</td>
	</tr>
</table>
<h4><a href="<%= request.getContextPath() %>">시작 화면으로 이동</a></h4>

</body>
</html>