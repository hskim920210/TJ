<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 제어문(choose)</title>
</head>
<body>

<%--
	JSTL의 c:choose 태그
	- 다수개의 조건식을 사용하여 분기할 수 있는 태그
	- 내부에 when 태그를 사용하여 다수개의 조건식을 정의할 수 있다.
	- 모든 when 태그의 조건식이 거짓일 경우에 otherwise 태그의 내용이 실행된다.
	- switch 구문의 case와 default와 유사하다.
--%>

<c:set var="age" value="${ param.age }" />

<h3>${ age / 10 }</h3>
<h3>${ age div 10 }</h3>
<h3>
<c:choose>
	<c:when test="${ age ge 10 and age lt 20 }">
		당신은 10대 입니다.
	</c:when>
	<c:when test="${ age ge 20 and age lt 30 }">
		당신은 20대 입니다.
	</c:when>
	<c:when test="${ age ge 30 and age lt 40 }">
		당신은 30대 입니다.
	</c:when>
	<c:when test="${ age ge 40 and age lt 50 }">
		당신은 40대 입니다.
	</c:when>
	<c:when test="${ age ge 50 and age lt 60 }">
		당신은 50대 입니다.
	</c:when>
	<c:otherwise>
		나이는 10 ~ 59 까지만 가능합니다.
	</c:otherwise>
</c:choose>
</h3>





</body>
</html>