<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생을 처리할 수 있는 JSP 페이지</title>
</head>
<body>

<%
	String strAge = request.getParameter("age").trim();
	int age = Integer.parseInt(strAge);
%>

<h2>입력된 나이 : <%= age %></h2>

</body>
</html>













