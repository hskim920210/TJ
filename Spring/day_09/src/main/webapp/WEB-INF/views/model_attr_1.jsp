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
	커맨드 객체는 뷰 페이지(JSP)에서 별도의 설정 없이 사용할 수 있는 객체
	뷰 페이지(JSP)에서 커맨드 객체에 접근할 때는
	커맨드 객체의 클래스 이름에서 첫 글자를 소문자로 변경하여 접근한다.
-->

<h3>아이디 : ${ member.id }</h3>
<h3>패스워드 : ${ member.password }</h3>
<h3>이름 : ${ member.name }</h3>


</body>
</html>