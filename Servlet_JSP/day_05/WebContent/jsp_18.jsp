<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/jsp_19.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생을 처리할 수 있는 JSP 페이지</title>
</head>
<body>

<%
	String id = request.getParameter("id").trim();
	
%>

<h2>입력된 ID : <%= id %></h2>

</body>
</html>













