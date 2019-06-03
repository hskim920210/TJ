<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, tje.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원 목록</title>
</head>
<body>

<%
	ArrayList<Member> list = 
		(ArrayList<Member>)request.getAttribute("list");
%>

<table>
	<tr>
		<th>인덱스</th>
		<th>아이디</th>
		<th>이름</th>		
	</tr>
<%
	for( int i = 0 ; i < list.size() ; i++ ) {
%>
	<tr>
		<th><%=i+1%></th>
		<th>
	
	<a href='<%=request.getContextPath()%>/member_detail?id=<%=list.get(i).getId()%>'>
	<%=list.get(i).getId()%></a></th>
	
	
		<th><%= list.get(i).getName() %></th>		
	</tr>
<%
	}
%>	
	
</table>

<a href='<%=request.getContextPath()%>/member_main'>메인화면으로 이동</a>
				
</body>
</html>




















