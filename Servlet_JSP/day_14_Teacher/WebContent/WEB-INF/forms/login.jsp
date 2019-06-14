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
			<th>MEMBER_ID</th>
			<td>			
			<input type="text" name="member_id" 
			value="${ not empty cookie.save_member_id ? cookie.save_member_id.value : '' }" required>
			${ errorMsg_ID}</td>
		</tr>
		<tr>
			<th>PW</th>	
			<td>
			<input type="password" name="password" required>
			${ errorMsg_PASSWORD }
			</td>			
		</tr>
		<tr>
			<th colspan="2">
			<label>ID 저장
			<input type="checkbox" name="save_member_id"
			${ not empty cookie.save_member_id ? 'checked' : '' } value="true">
			</label>
			</th>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="로그인"></th>
		</tr>
	</table>
</form>

<p><a href='<%= request.getContextPath() %>/main.do'>메인화면으로 이동</a></p>

</body>
</html>