<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 자바 빈 클래스(Member)를 사용하기 위한 import 구문  -->
<%@ page import="tje.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
</head>

<%
	// 서블릿에서 저장한 폼 데이터의 자바 빈 객체를 request 영역에서 추출
	Member member = (Member)request.getAttribute("member");
	// 서블릿에서 저장한 회원가입 결과를 request 영역에서 추출
	Integer result = (Integer)request.getAttribute("result");
%>

<body>

<% 
	if (result == 1) {
%>
	<h3>회원가입에 성공했습니다.</h3>

<% 
	} else {
%>
	<h3>회원가입에 실패했습니다.</h3>
	<h4>아래의 입력한 정보를 확인하세요.</h4>
<% 	} %>
<table>
		<tr>
			<th>ID</th>
			<td><%= member.getId() %></td>
		</tr>	
		<tr>
			<th>PW</th>
			<td><%= member.getPassword() %></td>
		</tr>
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
				<a href='<%= request.getContextPath() %>/member_main'>메인화면으로 이동</a>
			</th>
		</tr>
	</table>

</body>
</html>