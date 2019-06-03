<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tje.model.*" %>
<%
	Member member = (Member)request.getAttribute("member");
	Integer result = (Integer)request.getAttribute("result");
	String msg = "회원정보 수정이 완료되었습니다.";
	if( result == 0 )
		msg = "회원정보 수정에 실패했습니다(패스워드를 확인하세요).";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= member.getName() %> 님의 정보수정 결과</title>
</head>
<body>

<h3><%= member.getName() %> 님의 <%= msg %></h3>

<p><a href='<%=request.getContextPath()%>/member_detail?id=<%=member.getId()%>'>상제정보화면으로 이동</a></p>
<p><a href='<%=request.getContextPath()%>/member_main'>메인화면으로 이동</a></p>

</body>
</html>








