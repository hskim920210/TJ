<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out을 이용한 구구단 출력</title>
</head>
<body>

<%! 
	public String[] dan(int i){
	String [] iDan = new String [9];
	for (int j = 1 ; j <= 9 ; j++){
		iDan[j-1] = i + " * " + j + " = " + i*j;
	}
	return iDan;
	}
%>

<%
	for(int i = 2 ; i <= 9 ; i++) {
		out.println("<h3>" +  i + "단</h3>");
		out.println("<ul>");
		
		for(int k = 0 ; k < 9 ; k++){
			out.println("<li>" + dan(i)[k] + "</li>");
		}
		out.println("</ul>");
	}
%>

</body>
</html>