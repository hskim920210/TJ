<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 완료 페이지</title>
</head>
<body>

<h1>'${ requestScope.updatedMember.name }' 님의 정보 수정이 완료되었습니다.</h1>

<table>		
		<tr>
			<th>ID</th>
			<td>${ requestScope.updatedMember.member_id }</td>
		</tr>
		<tr>
			<th>NAME</th>
			<td>${ requestScope.updatedMember.name }</td>
		</tr>
		<tr>
			<th>GENDER</th>
			<td>${ requestScope.updatedMember.genderString }</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td>${ requestScope.updatedMember.age eq 0 ? '나이 입력 안함' : requestScope.updatedMember.age }</td>
		</tr>
		<tr>
			<th>BIRTH</th>
			<td>${ requestScope.updatedMember.birthString }</td>
		</tr>
		<tr>
			<th>TEL</th>
			<td>${ empty requestScope.updatedMember.tel ? '연락처 입력 안함' : requestScope.updatedMember.tel }</td>
		</tr>
		<tr>
			<th>ADDRESS</th>
			<td>${ empty requestScope.updatedMember.address ? '주소 입력 안함' : requestScope.updatedMember.address }</td>
		</tr>
		<tr>
			<th>REGIST_DATE</th>
			<td>${ requestScope.updatedMember.regist_dateString }</td>
		</tr>
		<tr>
			<th colspan="2">
				<a href='${pageContext.request.contextPath}/main.do'>메인화면으로 이동</a>
			</th>
		</tr>
</table>

</body>
</html>