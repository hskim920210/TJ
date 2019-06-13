<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 확인</title>
</head>
<body>

<h2 style=color:red>'${ sessionScope.login_member.name }' 님의 정보</h2>

<table border="1" style="text-align: center; font-size: 20px; width: 800px">
	<tr>
	<td>ID</td>
	<td>${ sessionScope.login_member.member_id }</td>
	</tr>
	<tr>
	<td>NAME</td>
	<td>${ sessionScope.login_member.name }</td>
	</tr>
	<tr>
	<td>GENDER</th>
	<td>${ sessionScope.login_member.gender }</td>
	</tr>
	<tr>
	<td>AGE</th>
	<td>${ sessionScope.login_member.age }</td>
	</tr>
	<tr>
	<td>BIRTH</th>
	<td>${ sessionScope.login_member.birth }</td>
	</tr>
	<tr>
	<td>TEL</th>
	<td>${ sessionScope.login_member.tel }</td>
	</tr>
	<tr>
	<td>ADDRESS</th>
	<td>${ sessionScope.login_member.address }</td>
	</tr>
	<tr>
	<td>REGIST_DATE</th>
	<td>${ sessionScope.login_member.regist_date }</td>
	</tr>
	<tr>
	<td>LAST_ACCES_TIME</th>
	<td>${ sessionScope.login_member.last_access_time }</td>
	</tr>
</table>

<p><a href='<%= request.getContextPath() %>/main.do'>메인화면으로 이동</a></p>

</body>
</html>