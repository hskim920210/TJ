<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버퍼의 활용</title>
</head>
<body>

<%
	for( int i = 2 ; i < 10 ; i++ ) {
		String strDan = String.format("<h3>%d 단을 출력합니다.</h3>", i);
		out.println(strDan);
		out.println("<ul>");
		for( int j = 1 ; j < 10 ; j++ ) {
			String strGuGuDan = String.format("<li>%d * %d = %d</li>", 
					i, j, i*j);
			out.println(strGuGuDan);
		}
		out.println("</ul>");
	}
%>

</body>
</html>





