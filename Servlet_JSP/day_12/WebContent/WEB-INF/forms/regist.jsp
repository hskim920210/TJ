<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

<form action="./regist.do" metod="post">
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" name="member_id" required></td>
		</tr>
		<tr>
			<th>PASSWORD</th>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
			<input type="radio" name="gender" value='1'>남
			<input type="radio" name="gender" value='2'>여
			</td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="number" name="age"></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="number" name="year" maxlength="4" min="1890" max="2019">년 
				<input type="number" name="month" maxlength="2" min="1" max="12">월 
				<input type="number" name="day" maxlength="2" min="1" max="31">일</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="tel"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="가입하기"></th>
		</tr>
	</table>
</form>



</body>
</html>