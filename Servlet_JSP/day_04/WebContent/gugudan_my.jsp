<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
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

<% for(int i = 2 ; i <= 9 ; i++) { %>
	<h3 style = "color:purple"><%= i %>단</h3>
	<ul>
		<% for(int k = 0 ; k < 9 ; k++){ %>
			<li style = "color:green"><%= dan(i)[k] %></li>
		<% } %>
	</ul>
<% } %>
</body>
</html>