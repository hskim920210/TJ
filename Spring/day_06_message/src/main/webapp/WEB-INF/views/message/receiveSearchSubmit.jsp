<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.receive" /></title>
</head>
<body>

<h3>검색결과에 해당되는 메세지(${ searchedCount }개)</h3>

<table border="1">
	<tr>
		<th><spring:message code="message.message_id" /></th>
		<th><spring:message code="message.sender" /></th>
		<th><spring:message code="message.check" /></th>
		<th><spring:message code="message.sendTime" /></th>
		<th><spring:message code="message.receiveTime" /></th>
	</tr>
<c:forEach items="${ searched }" var="message">
	<tr>
		<th>${ message.message_id }</th>
		<th>${ message.sender }</th>
		<%-- 
		<th><a href="<%= request.getContextPath() %>/message/receive_detail?message_id=${rmsg.message_id}">내용확인</a></th>
		--%>
		<th><a href="<%= request.getContextPath() %>/message/content/${message.message_id}">내용확인</a></th>
		<th>${ message.send_time }</th>
		<th>${ empty message.receive_time ? '읽지않음' : message.receive_time }</th>
	</tr>
</c:forEach>
</table>


<form:form>
	<p>메세지 받은 날짜(시작) : 
	<form:input path="from" />
	</p>
	<p>메세지 받은 날짜(종료) :
	<form:input path="to" />
	</p>	
	<p>
	<input type="submit" value="검색">
	<input type="reset" value="초기화">
	</p>
</form:form>



<h3><a href="<%= request.getContextPath() %>/message/receive_notRead"><spring:message code="toNotRead" /></a></h3>

<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>

</body>
</html>