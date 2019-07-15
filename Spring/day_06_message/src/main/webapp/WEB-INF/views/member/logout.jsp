<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.logout" /></title>
</head>
<body>

<h3><spring:message code="logout.complete" arguments="${ member.name }" /></h3>
<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>

</body>
</html>