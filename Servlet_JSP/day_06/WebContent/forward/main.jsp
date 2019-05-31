<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String forwardPage = null;
	String strAge = request.getParameter("age");
	int nAge = Integer.parseInt(strAge);
	if(nAge > 20) {
		forwardPage = "/forward/adult.jsp";
	} else {
		forwardPage = "/forward/child.jsp";
	}
%>

<jsp:forward page="<%= forwardPage %>"></jsp:forward>

</body>
</html>