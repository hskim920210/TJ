<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<h2>회원 정보 입력</h2>
<form:form action="model_attr_3" modelAttribute="m">
	<p>
		<label>아이디 : <br><form:input path="id"/></label>
	</p>
	<p>
		<label>비밀번호 : <br><form:password path="password"/></label>
	</p>
	<p>
		<label>이름 : <br><form:input path="name"/></label>
	</p>
	<input type="submit" value="가입 완료">
</form:form>


<h3>아이디 : ${ m.id }</h3>
<h3>패스워드 : ${ m.password }</h3>
<h3>이름 : ${ m.name }</h3>

</body>
</html>