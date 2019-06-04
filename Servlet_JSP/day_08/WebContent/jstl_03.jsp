<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="tje.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 변수의 참조 (특정 영역에 저장된 변수를 참조)</title>
</head>
<body>

<%
	HashMap<String, Integer> map = new HashMap<>();
	map.put("One", 1);
	map.put("Two", 2);
	map.put("Three", 3);
	pageContext.setAttribute("map", map);
%>

<h3>map.One = ${ map.One }</h3>
<h3>map.Two = ${ map.Two }</h3>
<h3>map.Three = ${ map.Three }</h3>

<!-- 
	page 영역에 저장된 strData의 값에 접근하여 수정하는 예제 
	c:set 태그를 사용하여 값을 수정할 수 있다.
	(주의사항 - 반드시 자바 빈 객체 또는 map 객체만 가능)
	- target 속성에는 수정할 객체를 참조할 수 있는 표현식 또는 EL식을 작성한다.
	- property 속성에는 값을 수정할 자바빈 객체의 멤버 필드 이름 또는
	  Map에 저장된 키의 값을 작성한다.
	- value 속성에는 수장할 값을 문자열 또는 표현식 또는 EL 식으로 작성
-->
<c:set target="${ map }" property="One" value="${ map.One * 10 }" />
<c:set target="${ map }" property="Two" value="${ map.Two * 10 }" />
<c:set target="${ map }" property="Three" value="${ map.Three * 10 }" />
<h3>map.One = ${ map.One }</h3>
<h3>map.Two = ${ map.Two }</h3>
<h3>map.Three = ${ map.Three }</h3>

</body>
</html>