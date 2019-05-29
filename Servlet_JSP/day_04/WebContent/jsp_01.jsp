<%--
	JSP 주석문 선언 방법
	
	JSP : Java Server Page 의 약자
	- 기존의 서블릿을 통한 웹 프로그래밍 방식에서 클라이언트의 화면 구성을 위한
		HTML 코드 작성의 불편함을 해소하기 위해 개발된 언어
	- JSP는 HTML과 Java 코드가 혼용되서 사용되는 구조를 가진다.
	- JSP는 대표적인 서버 사이드 스크립트의 일종
		(서버 사이드 스크립트인 JSP는 서버에서 실행되어 실행의 결과만 
		클라이언트로 전달하기 때문에 JSP의 주석 및 실행코드를 클라이언트에서 
		확인할 수 없다.)
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP ~ !</title>
</head>
<body>

<%
	String msg = "Hello JSP ~ !";
%>

<h2>MSG -> <%= msg %></h2>

</body>
</html>