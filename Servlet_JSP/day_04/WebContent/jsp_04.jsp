
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>

<form action="./jsp_05.jsp" method="post">
<table>
		<caption>로그인</caption>
		<tr>
			<th>ID</th>
			<th>PW</th>			
		</tr>
		<tr>
			<td><input type="text" name="id" required></td>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="로그인"></th>
		</tr>
	</table>
</form>

</body>
</html>