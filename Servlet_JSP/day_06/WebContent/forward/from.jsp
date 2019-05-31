<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>from.jsp 페이지</title>
</head>
<body>

<%
	request.setAttribute("data", "ABC");
%>

<h3>from.jsp 페이지의 시작입니다.</h3>

<jsp:forward page="/forward/to.jsp"/>

<h3>from.jsp 페이지의 종료입니다.</h3>

</body>
</html>