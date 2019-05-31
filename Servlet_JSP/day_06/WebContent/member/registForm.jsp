<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/member/registData.jsp" method="post">
	<table>
		<caption>회원가입</caption>
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>TEL</th>
			<th>ADDRESS</th>			
		</tr>
		<tr>
			<td><input type="text" name="id" required></td>
			<td><input type="password" name="password" required></td>
			<td><input type="text" name="name" required></td>
			<td><input type="text" name="age"></td>
			<td><input type="text" name="tel"></td>			
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<th colspan="6"><input type="submit" value="가입"></th>
		</tr>
	</table>
</form>

</body>
</html>