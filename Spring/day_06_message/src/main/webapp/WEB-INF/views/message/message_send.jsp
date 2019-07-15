<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보낸 메세지함</title>
</head>
<body>

<table border="1">
	<tr>
		<th><spring:message code="message.message_id" /></th>
		<th><spring:message code="message.receiver" /></th>
		<th><spring:message code="message.content" /></th>
		<th><spring:message code="message.sendTime" /></th>
		<th><spring:message code="message.receiveTime" /></th>
	</tr>
	<tr>
		<th>${ message.message_id }</th>
		<th>${ message.receiver }</th>
		<th>${ message.content }</th>
		<th>${ message.send_time }</th>
		<th>${ empty message.receive_time ? '읽지않음' : message.receive_time }</th>
	</tr>
</table>
<h4><a href="<%= request.getContextPath() %>/message/send"><spring:message code="toSend" /></a></h4>
<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>

</body>
</html>