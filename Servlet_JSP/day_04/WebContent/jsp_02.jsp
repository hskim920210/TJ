<%--
	page 디렉티브
	- 현재 JSP 페이지의 속성을 지정하는 디렉티브
	- 버퍼의 크기, 인코딩, import 구문등을 처리할 수 있다.
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	<%@ page import="java.util.*, java.text.*" %>
 --%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 시간을 출력하는 JSP 페이지</title>
</head>
<body>

<%
	Date now = Calendar.getInstance().getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
%>

<h2>현재 시간 : <%= sdf.format(now) %></h2>

</body>
</html>