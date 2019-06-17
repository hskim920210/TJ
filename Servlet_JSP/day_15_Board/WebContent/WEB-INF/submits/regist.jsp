<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리 결과</title>
</head>

<body>

	<h3>회원가입에 성공했습니다.</h3>
	
	<table>		
		<tr>
			<th>ID</th>
			<td>${ member.member_id }</td>
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
			<th>GENDER</th>
			<td>${ member.genderString }</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td>${ member.age eq 0 ? '나이 입력안함' : member.age }</td>
		</tr>
		<tr>
			<th>BIRTH</th>
			<td>${ member.birthString }</td>
		</tr>
		<tr>
			<th>TEL</th>
			<td>${ empty member.tel ? '연락처 입력안함' : member.tel }</td>
		</tr>
		<tr>
			<th>ADDRESS</th>
			<td>${ empty member.address ? '주소 입력안함' : member.address }</td>
		</tr>
		<tr>
			<th>REGIST_DATE</th>
			<td>${ member.regist_dateString }</td>
		</tr>
		<tr>
			<th colspan="2">
				<a href='${pageContext.request.contextPath}/main.do'>메인화면으로 이동</a>
			</th>
		</tr>
	</table>

</body>
</html>




