<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register" /></title>
</head>
<body>

<h2><spring:message code="member.info" /></h2>
<form>
	<label>
		<input type="checkbox" name="agree" value="true">
		<spring:message code="term.agree" />
	</label>
	<input type="submit" value="<spring:message code="next.btn" />" />
</form>

</body>
</html>