<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tje.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Member member = (Member)request.getAttribute("member");
%>

<form action="./member_update" method="post">
	<input type="hidden" name="id" value='<%=member.getId()%>'>
	
	<table>
		<caption>회원정보 수정</caption>
		<tr>
			<th>ID</th>
			<td><%=member.getId()%></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name" value="<%=member.getName()%>" required></td>
		</tr>
		<tr>
			<th>AGE</th>
			<td><input type="text" name="age" value="<%=member.getAge()%>"></td>
		</tr>
		<tr>
			<th>TEL</th>
			<td><input type="text" name="tel" value="<%=member.getTel()%>"></td>
		</tr>
		<tr>
			<th>ADDRESS</th>	
			<td><input type="text" name="address" value="<%=member.getAddress()%>"></td>		
		</tr>		
		<tr>
			<th colspan="2"><input type="submit" value="수정"></th>
		</tr>
	</table>
</form>

<p><a href='<%=request.getContextPath()%>/member_detail?id=<%=member.getId()%>'>상제정보화면으로 이동</a></p>
<p><a href='<%=request.getContextPath()%>/member_main'>메인화면으로 이동</a></p>

</body>
</html>















