<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/regist.do" method="post">
	<table>
		<caption>회원가입</caption>
		<tr>
			<th>ID</th>
			<td><input type="text" name="member_id" required> ${ errorMsg }</td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name" value="${ param.name }" required></td>
		</tr>
		<tr>
			<th>GENDER</th>
			<td>
			<label>남성 <input type="radio" name="gender" value="1" ${ empty param.gender or param.gender eq 1 ? 'checked' : '' }></label>
			/ <label>여성 <input type="radio" name="gender" value="2" ${ not empty param.gender and param.gender eq 2 ? 'checked' : '' }></label>
			</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td><input type="text" value="${ param.age }" name="age"></td>
		</tr>
		<tr>
			<th>BIRTH</th>
			<td>
			년 : <input type="text" size="4" name="year" value="${ param.year }">
			월 : <input type="text" size="2" name="month" value="${ param.month }">
			일 : <input type="text" size="2" name="day" value="${ param.day }">
			</td>
		</tr>
		<tr>
			<th>TEL</th>
			<td><input type="text" name="tel" value="${ param.tel }"></td>
		</tr>
		<tr>
			<th>ADDRESS</th>	
			<td><input type="text" name="address" value="${ param.address }"></td>		
		</tr>		
		<tr>
			<th colspan="2"><input type="submit" value="가입"></th>
		</tr>
	</table>
</form>

<p><a href='<%= request.getContextPath() %>/main.do'>메인화면으로 이동</a></p>

</body>
</html>