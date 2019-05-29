
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취미를 선택하세요</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/jsp_09.jsp" method="post">
	<caption>취미를 선택하세요</caption>
		<table>
			<tr>
				<td><p><label><input type="checkbox" name="hobby" value = "java">java</label></p></td>
				<td><p><label><input type="checkbox" name="hobby" value = "database">database</label></p></td>
			</tr>
			<tr>
				<td><p><label><input type="checkbox" name="hobby" value = "servlet">servlet</label></p></td>
				<td><p><label><input type="checkbox" name="hobby" value = "jsp">jsp</label></p></td>
			</tr>
			<tr>
				<td><p><label><input type="checkbox" name="hobby" value = "javascript">javascript</label></p></td>
			</tr>
		</table>
</form>

</body>
</html>