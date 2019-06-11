<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

<h2>메인 메뉴</h2>

<!-- 
		out.println("<ul>");
		if( login_id != null ) {
			out.println("<li><a href='./auth/member_list'>회원목록 보기</a></li>");
			out.println("<li><a href='./auth/member_logout'>로그아웃</a></li>");
		} else {		
			out.println("<li><a href='./member_regist'>회원가입</a></li>");
			out.println("<li><a href='./member_login'>로그인</a></li>");
		}
		out.println("</ul>");

 -->
 
<c:if test="${ not empty sessionScope.login_id and not empty applicationScope.login_member_count }">
	<h3>현재 접속된 클라이언트의 수 : ${applicationScope.login_member_count}</h3>
</c:if>

<c:if test="${ not empty sessionScope.login_id and empty applicationScope.login_member_count }">
	<h3>현재 접속된 클라이언트의 수 : 0</h3>
</c:if>

<ul>

<c:if test="${ empty sessionScope.login_id }" var="result">
	<li><a href='<%= request.getContextPath() %>/regist.do'>회원가입</a></li>
	<li><a href='<%= request.getContextPath() %>/login.do'>로그인</a></li>
</c:if>

<c:if test="${ not result }">
	<li><a href='<%= request.getContextPath() %>/auth/list.do'>회원목록 보기</a></li>
	<li><a href='<%= request.getContextPath() %>/auth/logout.do'>로그아웃</a></li>

</c:if>

</ul>

</body>
</html>