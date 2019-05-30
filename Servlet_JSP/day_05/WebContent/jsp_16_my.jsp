<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

<%-- 
	현재 페이지는 로그인을 위한 JSP 입니다.
	현재 접속된 사용자가 로그인이 되어있지 않은 상황이라면
	로그인 정보를 입력받을 수 있는 폼을 화면에 출력하고
	로그인 된 사용자라면 "이미 로그인 되어 있습니다." 라는
	메세지를 화면에 출력하세요.
	(로그인 정보의 처리는 jsp_17.jsp에서 수행한다.)
	(로그인 정보는 session 객체에 저장하며 login_id 속성에 
	 로그인 된 ID 값을 저장하여 처리한다.)
	(로그인은 ID와 PW가 동일한 경우 로그인으로 처리한다.) 
--%>

<% 
	boolean isLogedIn = false;
	if(request.getSession().getAttribute("id") != null) {
		isLogedIn = true;
	}
	
	if(isLogedIn) {
		out.println("이미 로그인 되어있습니다.");
	} else {
		out.println("<table>");
		out.println("<form action=\"./jsp_17_my.jsp\" name=\"loginform\">");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<td><input type=\"text\" name=\"id\" required></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>PW</th>");
		out.println("<td><input type=\"password\" name=\"pw\" required></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th colspan=\"2\"><input type=\"submit\" name=\"login\" value=\"로그인\"></th>");
		out.println("</tr>");
		out.println("</form>");
		out.println("</table>");
	}
%>

</body>
</html>