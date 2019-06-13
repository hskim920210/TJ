<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 확인</title>
</head>
<body>

	<h3>'${ login_member.member_id }' 님의 개인정보 확인 페이지 입니다.</h3>
	
	<table>		
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
			<td>${ login_member.genderString }</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td>${ login_member.age eq 0 ? '나이 입력 안함' : login_member.age }</td>
		</tr>
		<tr>
			<th>BIRTH</th>
			<td>${ login_member.birthString }</td>
		</tr>
		<tr>
			<th>TEL</th>
			<td>${ empty login_member.tel ? '연락처 입력 안함' : member.tel }</td>
		</tr>
		<tr>
			<th>ADDRESS</th>
			<td>${ empty login_member.address ? '주소 입력 안함' : member.address }</td>
		</tr>
		<tr>
			<th>REGIST_DATE</th>
			<td>${ login_member.regist_dateString }</td>
		</tr>
		<tr>
			<th>LAST_ACCESS_TIME</th>
			<td>${ login_member.last_access_timeString }</td>
		</tr>
		<tr>
			<th colspan="2">
				<a href='${pageContext.request.contextPath}/auth/member_update.do'>개인정보 수정</a>
			</th>
		</tr>
		<tr>
			<th colspan="2">
				<a href='${pageContext.request.contextPath}/main.do'>메인화면으로 이동</a>
			</th>
		</tr>
	</table>

</body>
</html>




