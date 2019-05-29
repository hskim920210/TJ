<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체크박스 타입의 폼 데이터 처리</title>
</head>
<body>

<%
	// 체크박스와 같은 경우 동일한 name으로 다수개의 value가 전달된다.
	// 이러한 경우 request 객체의 getParameterValues 메소드를 사용하여
	// 동일한 이름으로 전달된 다수개의 값을 읽어올 수 있다.
	String [] hobbyArray = request.getParameterValues("hobby");
%>

<h2>선택한 취미 항목들 ...</h2>

<ul>
	<% for( String hobby : hobbyArray ) { %>
		<li><%= hobby %></li>
	<% } %>
</ul>

</body>
</html>