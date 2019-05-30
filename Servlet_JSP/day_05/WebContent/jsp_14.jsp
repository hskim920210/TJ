<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 객체 활용</title>
</head>
<body>

<%
String strJDBCUser = application.getInitParameter("JDBC_USER");
String strJDBCPW = application.getInitParameter("JDBC_PASSWORD");
%>

<h3>JDBC 접속에 사용할 계정 : <%= strJDBCUser %></h3>
<h3>JDBC 접속에 사용할 패스워드 : <%= strJDBCPW %></h3>

</body>
</html>