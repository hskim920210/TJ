<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.register" /></title>
</head>
<body>

<c:if test="${ insert_result }">
	<h3><spring:message code="regist.submitComplete" arguments="${ member.name }" /></h3>
	<h4><spring:message code="regist.toLogin" /></h4>
	<h4><a href="<%= request.getContextPath() %>/member/login"><spring:message code="toLogin" /></a></h4>
</c:if>

<c:if test="${ not insert_result }">
	<h3><spring:message code="regist.submitFail" arguments="${ member.name }" /></h3>
	<h4><spring:message code="regist.askToAdmin" /></h4>
	<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>
</c:if>

</body>
</html>