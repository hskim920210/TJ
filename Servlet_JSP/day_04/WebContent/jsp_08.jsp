<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체크박스 타입의 폼 데이터 입력 화면</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/jsp_09.jsp" method="post">
	<table>
		<caption>취미를 입력하세요</caption>
		<tr>
			<td><label>Java <input type="checkbox" name="hobby" value="java"></label></td>
			<td><label>Database <input type="checkbox" name="hobby" value="database"></label></td>				
		</tr>
		<tr>
			<td><label>HTML <input type="checkbox" name="hobby" value="html"></label></td>
			<td><label>CSS <input type="checkbox" name="hobby" value="css"></label></td>				
		</tr>
		<tr>
			<td><label>JavaScript <input type="checkbox" name="hobby" value="javascript"></label></td>
			<td><label>JQuery <input type="checkbox" name="hobby" value="jquery"></label></td>				
		</tr>
		<tr>
			<td><label>Servlet <input type="checkbox" name="hobby" value="servlet"></label></td>
			<td><label>JSP <input type="checkbox" name="hobby" value="jsp"></label></td>				
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="확인"></th>
		</tr>
	</table>
</form>

</body>
</html>






