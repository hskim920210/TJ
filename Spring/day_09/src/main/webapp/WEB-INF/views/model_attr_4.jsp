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

<!-- 
	커맨드 객체를 사용하여 FORM 태그를 작성하는 커스텀 태그
-->

<form:form modelAttribute="m"  > <!-- modelAttribute="m"(높은버전 호환) 은 commandName="m" 과 같음 -->
	<form:input path="id"/>
	<form:password path="password"/>
	<form:input path="name"/>
</form:form>


<h3>아이디 : ${ m.id }</h3>
<h3>패스워드 : ${ m.password }</h3>
<h3>이름 : ${ m.name }</h3>

</body>
</html>