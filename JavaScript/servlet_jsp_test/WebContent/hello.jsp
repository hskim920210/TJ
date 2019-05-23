<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- jsp 파일은 webcontent 안에 한다 -->

<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP ~ !</title>
</head>
<body>

<!-- <% %>은 자바코드를 실행하겠다 -->
<%
	String msg = "<h1>Hellow JSP ~ !</h1>";
	out.println(msg);
%>

</body>
</html>