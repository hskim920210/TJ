<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.login" /></title>
<!-- c태그의 테스트에 의해 페이지가 읽힐 때, 경고창이 뜰지 말지 분기가 된다. -->
<c:if test="${ isLogin eq false }">
	<script type="text/javascript">
		alert("입력된 아이디는 존재하지 않습니다.");		
	</script>
</c:if>
</head>
<body>


<h3><spring:message code="login.guide" /></h3>

<form:form modelAttribute="member">
	<table>
		<caption><spring:message code="login.tableCaption" /></caption>
		<tr>
			<th><spring:message code="login.id" /></th>
			<td><form:input path="member_id" />
			<label><spring:message code="login.remember" /><form:checkbox path="rememberID" /></label></td>
		</tr>
		<tr>
			<th><spring:message code="login.pw" /></th>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="<spring:message code="login.submit" />">
			<input type="reset" value="<spring:message code="login.reset" />"></th>
		</tr>
	</table>
</form:form>
<h4><a href="<%= request.getContextPath() %>"><spring:message code="toMain" /></a></h4>
</body>
</html>