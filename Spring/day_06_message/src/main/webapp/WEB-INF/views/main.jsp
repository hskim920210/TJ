<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.main" /></title>
</head>
<body>

<c:if test="${ empty sessionScope.loginMember }" var="r">
	<h3><a href="<%= request.getContextPath() %>/member/insert"><spring:message code="main.register" /></a></h3>
	<h3><a href="<%= request.getContextPath() %>/member/login"><spring:message code="main.login" /></a></h3>
</c:if>

<c:if test="${ not r }">
	<h3><spring:message code="login.welcome" arguments="${ loginMember.name }" /></h3>
	<h3><a href="<%= request.getContextPath() %>/message/receive/"><spring:message code="main.receive" arguments="${ r_count }" /></a></h3>
	<h3><a href="<%= request.getContextPath() %>/message/send/"><spring:message code="main.send" arguments="${s_count}" /></a></h3>
	<h3><a href="<%= request.getContextPath() %>/message/transform"><spring:message code="main.transform" /></a></h3>
	<h3><a href="<%= request.getContextPath() %>/member/logout"><spring:message code="main.logout" /></a></h3>
</c:if>

</body>
</html>