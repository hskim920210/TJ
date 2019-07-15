<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커맨드 객체 사용</title>
</head>
<body>

<!--
	커맨드 객체에 접근하는 이름은 @ModelAttribute 으로 변경할 수 있다.
-->

<h3>아이디 : ${ m.id }</h3>
<h3>패스워드 : ${ m.password }</h3>
<h3>이름 : ${ m.name }</h3>

</body>
</html>