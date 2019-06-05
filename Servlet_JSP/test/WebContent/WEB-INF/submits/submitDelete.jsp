<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tje.model.*" %>
<%
	Member member = (Member)request.getAttribute("member");
	Integer result = (Integer)request.getAttribute("result");
	String msg = "회원정보 삭제가 완료되었습니다.";
	if( result == 0 ) {
		msg = "회원정보 삭제에 실패했습니다.(패스워드를 확인하세요.)";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ member.name } 님의 정보 삭제 결과</title>
</head>
<body>
<h3>${ member.name } 님의 <%=msg%></h3>

<p><a href='${pageContext.request.contextPath}/member_main'>메인화면으로 이동</a></p>
</body>
</html>