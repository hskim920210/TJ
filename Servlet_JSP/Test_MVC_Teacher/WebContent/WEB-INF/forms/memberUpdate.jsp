<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/auth/member_update" method="post">
	<input type="hidden" name="id" value='${ member.id }'>
	
	<table>
		<caption>회원정보 수정</caption>
		<tr>
			<th>ID</th>
			<td>${ member.id }</td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name" value="${ member.name }" required></td>
		</tr>
		<tr>
			<th>AGE</th>
			<td><input type="text" name="age" value="${ member.age }"></td>
		</tr>
		<tr>
			<th>TEL</th>
			<td><input type="text" name="tel" value="${ member.tel }"></td>
		</tr>
		<tr>
			<th>ADDRESS</th>	
			<td><input type="text" name="address" value="${ member.address }"></td>		
		</tr>		
		<tr>
			<th colspan="2"><input type="submit" value="수정"></th>
		</tr>
	</table>
</form>

<p><a href='${pageContext.request.contextPath}/auth/member_detail?id=${ member.id }'>상제정보화면으로 이동</a></p>
<p><a href='${pageContext.request.contextPath}/member_main'>메인화면으로 이동</a></p>

</body>
</html>















