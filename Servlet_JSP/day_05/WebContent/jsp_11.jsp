<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
	page 디렉티브의 buffer 속성은 출력 버퍼의 크기를 지정할 수 있는 속성
	autoFlush 속상은 자동플러시를 지정할 수 있는 속성
	저장의 최소 단위 bit
	8bit = 1byte
	1024byte = 1kb
 --%>    
<%@ page buffer="1kb" autoFlush="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버퍼의 활용</title>
</head>
<body>

<%
	for( int i = 1 ; i < 5000 ; i++ ) {
		out.print("<h3>");
		out.println(i);
		out.print("</h3>");
	}
%>

</body>
</html>