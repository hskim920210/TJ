<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP를 활용한 구구단 예제</title>

<style type="text/css">
	h3 {
		background-color: yellow;
	}
	li {
		color: green;
	}
</style>

</head>
<body>

<% for( int i = 2 ; i < 10 ; i++ ) { %>
	<h3><%= i %>단을 출력합니다.</h3>
	<ul>
<% 		for( int j = 1 ; j < 10 ; j++ ) { %>
			<li><%= i %> * <%= j %> = <%= i * j %></li>
<% 		} %>
	</ul>
<% } %>

</body>
</html>
















