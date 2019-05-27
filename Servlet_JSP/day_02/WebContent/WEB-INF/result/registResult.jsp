<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 유효성 체크 결과</title>
</head>
<body>

	<h1>회원가입 유효성 체크 결과</h1>
	
	<h2>ID : <%= request.getParameter("id") %> (<%= request.getAttribute("bIdValid") %>)</h2>
	<h2>PW : <%= request.getParameter("pw") %> (<%=request.getAttribute("bPwValid") %>)</h2>
	<h2>NAME : <%= request.getParameter("name") %> (<%= request.getAttribute("bNameValid") %>)</h2>
	<h2>AGE : <%= request.getParameter("age") %> (<%= request.getAttribute("bAgeValid") %>)</h2>
	<h2>TEL : <%= request.getParameter("tel") %> (<%= request.getAttribute("bTelValid") %>)</h2>


</html>