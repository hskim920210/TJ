<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/auth/member_update.do" method="post">
	<input type="hidden" name="member_id" value='${ login_member.member_id }'>
	
	<table>
		<caption>회원정보 수정</caption>
		<tr>
			<th>ID</th>
			<td>${ login_member.member_id }</td>
		</tr>
		<tr>
			<th>NAME</th>
			<td>${ login_member.name }</td>
		</tr>
		<tr>
			<th>GENDER</th>
			<c:if test="${ login_member.gender == 1 }" var="man">
				<td>남</td>
			</c:if>
			<c:if test="${ !man }"><td>여</td></c:if>
		</tr>
		<tr>
			<th>AGE</th>
			<td><input type="text" name="age" value="${ login_member.age }"></td>
		</tr>
		<tr>
			<th>BIRTH</th>
			<td><input type="text" name="birth" value="${ login_member.birthString }"></td>
		</tr>
		<tr>
			<th>TEL</th>
			<td><input type="text" name="tel" value="${ login_member.tel }"></td>
		</tr>
		<tr>
			<th>ADDRESS</th>	
			<td><input type="text" name="address" value="${ login_member.address }"></td>		
		</tr>	
		<tr>
			<th>REGIST_DATE</th>
			<td>${ login_member.regist_dateString }</td>
		</tr>	
		<tr>
			<th colspan="2"><input type="submit" value="수정"></th>
		</tr>
	</table>
</form>

<p><a href='${pageContext.request.contextPath}/auth/detail.do?id=${ login_member.member_id }'>상제정보화면으로 이동</a></p>
<p><a href='${pageContext.request.contextPath}/main.do'>메인화면으로 이동</a></p>
</html>