<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.send" /></title>
</head>
<body>

<h3><spring:message code="message.sendAll" arguments="${ loginMember.name }, ${ s_count }" /></h3>

<table border="1">
	<tr>
		<th><spring:message code="message.message_id" /></th>
		<th><spring:message code="message.receiver" /></th>
		<th><spring:message code="message.check" /></th>
		<th><spring:message code="message.sendTime" /></th>
		<th><spring:message code="message.receiveTime" /></th>
	</tr>
<c:forEach items="${ sList }" var="smsg">
	<tr>
		<th>${ smsg.message_id }</th>
		<th>${ smsg.receiver }</th>
		<%-- 
		<th><a href="<%= request.getContextPath() %>/message/receive_detail?message_id=${rmsg.message_id}">내용확인</a></th>
		--%>
		<th><a href="<%= request.getContextPath() %>/message/content_send/${smsg.message_id}">내용확인</a></th>
		<th>${ smsg.send_time }</th>
		<th>${ empty smsg.receive_time ? '읽지않음' : smsg.receive_time }</th>
	</tr>
</c:forEach>
	<tr>
		<th colspan="5">
		
		<c:if test="${ beforePageNo ne -1 }">
		<a href="<%= request.getContextPath() %>/message/send/${beforePageNo}">이전</a></c:if>
		
			<c:forEach var="pageNo" begin="${ startPageNo }" end="${ endPageNo }">
				<c:if test="${ curPage eq pageNo }" var="r">
					<b style="font-size: 20px">[${pageNo}]</b>
				</c:if>
				<c:if test="${ not r }">
					<a href="<%= request.getContextPath() %>/message/send/${pageNo}">${pageNo}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${ afterPageNo ne -1 }">
		<a href="<%= request.getContextPath() %>/message/send/${afterPageNo}">다음</a></c:if>
		</th>
	</tr>
</table>

<form action="<%= request.getContextPath() %>/message/sendSearch" method="post">
	<p>메세지 보낸 날짜(시작) :
	<input type="text" name="from" placeholder="EX) 2019-07-12 12:00:00">
	</p>
	<p>메세지 보낸 날짜(종료) :
	<input type="text" name="to" placeholder="EX) 2019-07-12 12:00:00">
	</p>
	<p>
	<input type="submit" value="검색">
	<input type="reset" value="초기화">
	</p>
</form>


<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>


</body>
</html>