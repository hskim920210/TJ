<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과</title>
</head>

<body>

<c:if test="${ result == 1 }">
	<h3>회원가입에 성공했습니다.</h3>
</c:if>
<c:if test="${ result == 0 }">
	<h3>회원가입에 실패했습니다.</h3>
	<h4>아래의 입력한 정보를 확인하세요.</h4>
</c:if>
	
	<table>		
		<tr>
			<th>ID</th>
			<td>${ member.id }</td>
		</tr>
		<tr>
			<th>PW</th>
			<td>${ member.password }</td>
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
				<a href='${pageContext.request.contextPath}/main.do'>메인화면으로 이동</a>
			</th>
		</tr>
	</table>

</body>
</html>




