<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 변수의 삭제 (특정 영역에 저장된 변수를 삭제)</title>
</head>
<body>
<%
	HashMap<String, Integer> map = new HashMap<>();
	map.put("One", 1);	map.put("Two", 2);	map.put("Three", 3);

	pageContext.setAttribute("map", map);	
%>

<h3>map.One = ${ map.One }</h3>
<h3>map.Two = ${ map.Two }</h3>
<h3>map.Three = ${ map.Three }</h3>

<!-- 
	특정 영역에 저장된 속성을 지우는 JSTL 태그
	c:remove var="변수명" scope="객체를 삭제할 영역이름"
	(scope -> page, request, session, application

	중요!
	만약 scope의 값을 지정하지 않으면
	var에 지정된 이름의 속성을 모든 영역에서 제거
-->
<c:remove var="map" scope="page" />

<%
	out.print("<h3>map 객체의 키</h3>");
	for(String key : map.keySet() )
		out.print("<h4>" + key + "</h4>");
%>

<h3>map.One = ${ map.One }</h3>
<h3>map.Two = ${ map.Two }</h3>
<h3>map.Three = ${ map.Three }</h3>

</body>
</html>