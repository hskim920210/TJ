<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
%>

<h2>회원 ID : <%= id %></h2>
<h2>회원 PASSWORD : <%= pw %></h2>
<h2>회원 NAME : <%= name %></h2>
<h2>회원 TEL : <%= tel %></h2>
<h2>회원 ADDRESS : <%= address %></h2>

<h3><a href = "./regist.html">돌아가기</a></h3>

</body>
</html>