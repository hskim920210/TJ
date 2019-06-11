<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/login.do" method="post">
	<table>		
		<tr>
			<th>ID</th>
			<td><input type="text" name="id" required></td>
						
		</tr>
		<tr>
			<th>PW</th>	
			<td><input type="password" name="password" required></td>			
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="로그인"></th>
		</tr>
	</table>
</form>

</body>
</html>