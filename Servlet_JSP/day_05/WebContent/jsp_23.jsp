<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/jsp_24.jsp" buffer="1kb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생을 처리할 수 있는 JSP 페이지</title>
</head>
<body>

<%
	// 특정 JSP 페이지에서 발생되는 에러를 처리하기 위해
	// errorPage 를 지정할 수 있다.
	// 다만, 현재 jsp 페이지에서 출력 버퍼의 내용이 단 한번이라도
	// 클라이언트에게 전달되면, 기존의 출력된 내용 이후에
	// 에러 페이지의 내용이 출력된다.
	for(int i = 1 ; i < 1000 ; i++) {
		out.print("<h3>");
		out.println(i);
		out.print("</h3>");
	}
	
	
	int num = Integer.parseInt("123A");
%>

<h2>num => <%= num %></h2>

</body>
</html>