<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Page</title>
</head>
<body>

<%! 
	public String printMessage(Date now) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		// response.setContentType 역할을 위에 <%@ page에서 설정함.
		String message = String.format("<h3>안녕하세요. 현재 시간은 %s 입니다.</h3>", sdf.format(now));
		return message;
	}
%>

<%
	Date now = new Date();
%>

<%= printMessage(now) %>

</body>
</html>