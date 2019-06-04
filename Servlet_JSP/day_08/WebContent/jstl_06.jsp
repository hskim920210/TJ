<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 출력</title>
</head>
<body>
<c:set var="msg" value="JSTL~!" />
<!-- 
	JSP의 기본 객체 out을 사용하지 않고
	태그를 사용하여 출력하는 방법	
-->
<h3>
<c:out value="Hello~"/>
<c:out value="${ msg }"/>
<!-- 
	default 속성을 사용하여 value에 지정된 표현식 또는 EL의 값이
	null인 경우 대체하여 출력할 내용을 지정할 수 있다. 
 -->
<c:out value="${ number }" default="number 속성의 값이 존재하지 않음" />
</h3>



</body>
</html>