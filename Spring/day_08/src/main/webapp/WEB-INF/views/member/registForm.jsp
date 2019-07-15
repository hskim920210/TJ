<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

<h2>회원 정보를 입력하세요.</h2>

<form:form action="${pageContext.request.contextPath}/member/regist" modelAttribute="member">
	<table>
		<caption>회원가입</caption>
		<tr>
			<th>아이디</th>
			<td>
				<form:input path="member_id" />
				<c:if test="${ idExist }"><span>아이디가 중복되었습니다.</span></c:if>
			</td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><form:password path="password" value="${member.password}" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><form:input path="name" value="${member.name}" /></td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="가입">
				<input type="reset" value="초기화">
			</th>
		</tr>
	</table>
</form:form>

</body>
</html>