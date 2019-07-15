<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.register" /></title>
</head>
<body>

<h3><spring:message code="regist.guide" /></h3>

<form:form action="<%= request.getContextPath() %>/member/insert" modelAttribute="member">
<table>
		<caption><spring:message code="regist.tableCaption" /></caption>
		<tr>
			<th><spring:message code="regist.id" /></th>
			<td><form:input path="member_id" /> 
				<c:if test="${ not empty member.member_id }">
				<span><spring:message code="regist.idExist" /></span></c:if></td>
		</tr>
		<tr>
			<th><spring:message code="regist.pw" /></th>
			<td><form:password path="password" value="${ member.password }" /></td>
		</tr>
		<tr>
			<th><spring:message code="regist.name" /></th>
			<td><form:input path="name" value="${ member.name }" /></td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="<spring:message code="regist.submit" />">
				<input type="reset" value="<spring:message code="regist.reset" />">
			</th>
		</tr>
	</table>
</form:form>
<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>

<%--
<form action="<%= request.getContextPath() %>/member/insert" method="post">
	<table>
		<caption>회원가입</caption>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="member_id" required> 
				<c:if test="${ not empty member }">
				<span>아이디가 중복되었습니다.</span></c:if></td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><input type="password" name="password" value="${ member.password }"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name=name value="${ member.name }"></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="가입"><input type="reset" value="정보초기화"></th>
		</tr>
	</table>
</form>
--%>

</body>
</html>