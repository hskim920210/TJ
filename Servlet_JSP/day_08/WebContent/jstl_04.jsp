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
	특정 속성의 값을 null 값으로 지정하는 예제
	(삭제가 되지진 않음)
-->
<c:set target="${ map }" property="One" value="null" />
<c:set target="${ map }" property="Four" value="def" />

<%
	out.print("<h3>map 객체의 키</h3>");
	for(String key : map.keySet() )
		out.print("<h4>" + key + "</h4>");
%>

<h3>map.One = ${ map.One }</h3>
<h3>map.Two = ${ map.Two }</h3>
<h3>map.Three = ${ map.Three }</h3>
<h3>map.Four = ${ map.Four }</h3>

</body>
</html>