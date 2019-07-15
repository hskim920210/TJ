<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<c:if test="${ isPass eq false }">
	<script type="text/javascript">
		var errorMsg = '${ loginError }';
		alert(errorMsg);
	</script>
</c:if>
</head>
<body>

<form:form modelAttribute="member">
	<table>
		<caption>로그인 정보 입력</caption>
		<tr>
			<th>아이디</th>
			<td><form:input path="member_id" /><label>아이디 저장</label><form:checkbox path="idSave" /></td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="로그인">			
			</th>
		</tr>
		
	</table>

</form:form>


</body>
</html>