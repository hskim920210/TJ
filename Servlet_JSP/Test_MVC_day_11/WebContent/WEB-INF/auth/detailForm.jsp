<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ member.name } 님의 상세 정보 화면</title>
</head>
<body>

	<h3>${ member.name }
		님의 상세 정보 화면
	</h3>

	<table>
		<tr>
			<th>ID</th>
			<td>${ member.id }</td>
		</tr>
		<tr>
			<th>PW</th>
			
<c:if test="${ sessionScope.login_id == requestScope.member.id }" var="result">
	<td>${ member.password }</td>
</c:if>
<c:if test="${ !result }">
	<td>로그인 된 계정의 패스워드만 확인할 수 있습니다.</td>
</c:if>	

		</tr>
		<tr>
			<th>NAME</th>
			<td>${ member.name }</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td>${ member.age }</td>
		</tr>
		<tr>
			<th>TEL</th>
			<td>${ member.tel }</td>
		</tr>
		<tr>
			<th>ADDRESS</th>
			<td>${ member.address }</td>
		</tr>
		<tr>
			<th colspan="2">
			<a href='${pageContext.request.contextPath}/auth/list.do'>회원목록화면으로 이동</a>			
			</th>
		</tr>
<c:if test="${ result }">
		<tr>
			<th colspan="2">
			<a href='${pageContext.request.contextPath}/auth/update.do?id=${member.id}'>[수정]</a>
			<a href='${pageContext.request.contextPath}/auth/delete.do?id=${member.id}'>[삭제]</a>
			</th>
		</tr>
</c:if>
		<tr>
			<th colspan="2">			
			<a href='${pageContext.request.contextPath}/main.do'>메인화면으로 이동</a>
			</th>
		</tr>		
	</table>
</body>
</html>









