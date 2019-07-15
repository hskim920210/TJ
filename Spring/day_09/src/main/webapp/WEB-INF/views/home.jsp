<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	<spring:message code="home.title" />
</h1>
<h3>
	<spring:message code="home.message" arguments="${ param.name }" />
</h3>
<h3>
	<spring:message code="home.ex" arguments="10,20,30" />
</h3>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
