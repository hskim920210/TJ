<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tje.model.*" %>

<%
	String login_id = (String)session.getAttribute("login_id");
	Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= member.getName() %> 님의 상세 정보 화면</title>
</head>
<body>

<h3><%= member.getName() %> 님의 상세 정보 화면</h3>

	<table>
		<tr>
			<th>ID</th>
			<td><%= member.getId() %></td>
		</tr>	
	<%
		if( login_id.equals(member.getId())) {
	%>
		<tr>
			<th>PW</th>
			<td><%= member.getPassword() %></td>
		</tr>
	<% 	} else { %>
			<th>PW</th>
			<td>로그인된 계정의 패스워드만 확인할 수 있습니다.</td>
	<% 	} %>		
		<tr>
			<th>NAME</th>
			<td><%= member.getName() %></td>
		</tr>
		<tr>
			<th>AGE</th>
			<td><%= member.getAge() %></td>
		</tr>
		<tr>
			<th>TEL</th>
			<td><%= member.getTel() %></td>
		</tr>
		<tr>			
			<th>ADDRESS</th>			
			<td><%= member.getAddress() %></td>
		</tr>
		<tr>
			<th colspan="2">
				<a href='<%= request.getContextPath() %>/member_list'>회원 목록 화면으로 이동</a>
			</th>
		</tr>
	<%
		if( login_id.equals(member.getId())) {
	%>
		<tr>
			<th colspan="2">
				<a href='<%= request.getContextPath() %>/member_update?id=<%=member.getId()%>'>[수정]</a>
				<a href='<%= request.getContextPath() %>/member_delete?id=<%=member.getId()%>'>[삭제]</a>
			</th>
		</tr>
	<% 	} %>
		<tr>
			<th colspan="2">
				<a href='<%= request.getContextPath() %>/member_main'>메인화면으로 이동</a>
			</th>
		</tr>
	</table>

</body>
</html>