<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<h3>로그인 정보를 입력하세요.</h3>

<form:form commandName="member">
	<table>
		<caption>로그인</caption>
		<tr>
			<th>아이디</th>
			<td>

				<form:input path="id" />
				<label>아이디 저장<form:checkbox path="rememberID" /></label>

			</td>
				
		</tr>
		<tr>
			<th>패스워드</th>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="로그인"><input type="reset" value="초기화"></th>
		</tr>
	</table>
</form:form>

</body>
</html>