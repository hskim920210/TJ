<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 확인을 위한 실행 에러</title>
</head>
<body>
<h3>'${ login_member.name }' 님의 개인정보 확인을 위해 패스워드를 입력해주세요</h3>
<form action="<%= request.getContextPath() %>/auth/member.do" method="post">
	<table>		
		<tr>
			<th>PW</th>	
			<td>
			<input type="password" name="password" required>
			</td>			
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="확인"></th>
		</tr>
	</table>
</form>

<p><a href='<%= request.getContextPath() %>/main.do'>메인화면으로 이동</a></p>

</body>
</html>