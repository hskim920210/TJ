<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생을 처리할 수 있는 JSP 페이지</title>
</head>
<body>

<h2>예외가 발생하여 이동한 페이지</h2>

<%--
	JSP의 기본 객체 exception
	예외를 처리하기 위한 jsp 페이지에서 사용할 수 있는 기본객체
	자바의 catch절과 같이 발생된 예외 객체를 전달받은 객체 
	주의사항!!
	반드시 page 디렉티브에 isErrorPage 속성을 true로 지정해야만
	사용할 수 있습니다.
--%>
<p><%= exception.getClass().getName() %> 예외 발생</p>

</body>
</html>













