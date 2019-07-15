<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.login" /></title>
</head>
<body>

<c:if test="${ login_result }">
	<h3><spring:message code="login.welcome" arguments="${ member.name }" /></h3>
	<h4><spring:message code="login.toMain" /></h4>
	<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>
</c:if>

<c:if test="${ not login_result }">
	<h3><spring:message code="login.fail" /></h3>
	<h4><spring:message code="login.fail.check" /></h4>
	<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>
	<h4><a href="<%= request.getContextPath() %>/member/login"><spring:message code="toLogin" /></a></h4>
</c:if>

</body>
</html>