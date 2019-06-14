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

<ul>
<c:if test="${ empty sessionScope.login_member }" var="result" >
	<li><a href='<%=request.getContextPath()%>/regist.do'>회원가입</a></li>
	<li><a href='<%=request.getContextPath()%>/login.do'>로그인</a></li>	
</c:if>
<c:if test="${ not result }" >	
	<li><a href='<%=request.getContextPath()%>/auth/member.do'>
	'${ login_member.name }'님의 개인정보 확인</a></li>
	<li><a href='<%=request.getContextPath()%>/auth/logout.do'>로그아웃</a></li>
	<li><a href='<%=request.getContextPath()%>/auth/article.do'>자유게시판</a></li>
</c:if>
</ul>

</body>
</html>









