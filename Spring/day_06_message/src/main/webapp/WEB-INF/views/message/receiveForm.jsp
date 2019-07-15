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

<h3><spring:message code="message.receiveAll" arguments="${ loginMember.name }, ${ r_count }" /></h3>

<table border="1">
	<tr>
		<th><spring:message code="message.message_id" /></th>
		<th><spring:message code="message.sender" /></th>
		<th><spring:message code="message.check" /></th>
		<th><spring:message code="message.sendTime" /></th>
		<th><spring:message code="message.receiveTime" /></th>
	</tr>
<c:forEach items="${ rList }" var="rmsg">
	<tr>
		<th>${ rmsg.message_id }</th>
		<th>${ rmsg.sender }</th>
		<%-- 
		<th><a href="<%= request.getContextPath() %>/message/receive_detail?message_id=${rmsg.message_id}">내용확인</a></th>
		--%>
		<th><a href="<%= request.getContextPath() %>/message/content/${rmsg.message_id}">내용확인</a></th>
		<th>${ rmsg.send_time }</th>
		<th>${ empty rmsg.receive_time ? '읽지않음' : rmsg.receive_time }</th>
	</tr>
	
	<!-- 페이징 -->
	
	
</c:forEach>
	<tr>
		<th colspan="5">
		
		<c:if test="${ beforePageNo ne -1 }">
		<a href="<%= request.getContextPath() %>/message/receive/${beforePageNo}">이전</a></c:if>
		
			<c:forEach var="pageNo" begin="${ startPageNo }" end="${ endPageNo }">
				<c:if test="${ curPage eq pageNo }" var="r">
					<b style="font-size: 20px">[${pageNo}]</b>
				</c:if>
				<c:if test="${ not r }">
					<a href="<%= request.getContextPath() %>/message/receive/${pageNo}">${pageNo}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${ afterPageNo ne -1 }">
		<a href="<%= request.getContextPath() %>/message/receive/${afterPageNo}">다음</a></c:if>
		</th>
	</tr>
</table>


<form action="<%= request.getContextPath() %>/message/receiveSearch" method="post">
	<p>메세지 받은 날짜(시작) : 
	<input type="text" name="from" placeholder="EX) 2019-07-12 12:00:00">
	</p>
	<p>메세지 받은 날짜(종료) :
	<input type="text" name="to" placeholder="EX) 2019-07-12 12:00:00">
	</p>	
	<p>
	<input type="submit" value="검색">
	<input type="reset" value="초기화">
	</p>

</form>



<h3><a href="<%= request.getContextPath() %>/message/receive_notRead"><spring:message code="toNotRead" /></a></h3>

<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>

</body>
</html>