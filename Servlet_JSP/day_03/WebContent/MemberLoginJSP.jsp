<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

<form action="./member_login" method="post">
<table>
		<caption>로그인</caption>
		<tr>
			<th>ID</th>
			<th>PW</th>			
		</tr>
		<tr>
			<% 
				Cookie [] cookies = request.getCookies();
				String save_id = null;
				for(int i = 0 ; cookies != null && i < cookies.length ; i++) {
					if(cookies[i].getName().equals("save_id")) {
						save_id = cookies[i].getValue();
					}	
				} 
				
				boolean saved = (save_id != null);
				
				if (saved) { %>
				<td><input type="text" name="id" value = "<%= save_id %>" required></td>
				<% } else { %>
				<td><input type="text" name="id" required></td>
				<% } %>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="로그인"></th>
		</tr>
		<tr>
			<% if (saved) { %>
			<th colspan="2"><label>아이디 저장<input type = "checkbox" name = "save_id" checked></label></th>
			<% } else { %>
			<th colspan="2"><label>아이디 저장<input type = "checkbox" name = "save_id"></label></th>
			<% } %>
		</tr>
	</table>
</form>

<form action = "./member_main" method="get">
<p><input type = "submit" value = "메인으로"></p>
</form>

<% 
	
%>

</body>
</html>