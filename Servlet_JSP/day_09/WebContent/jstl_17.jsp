<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 반복문</title>
</head>
<body>

<%
	HashMap<String, Integer> map = new HashMap<>();
	map.put("one", 1);
	map.put("two", 2);
	map.put("three", 3);
	map.put("four", 4);
	map.put("five", 5);

	pageContext.setAttribute("map", map);
%>

<h2>리스트의 내용 출력</h2>
<!-- 
특정 리스트, 맵을 순회하기 위한 c:forEach 태그
- Map 객체를 순회하는 경우 var 속성에 정의된 이름의 객체에
  key와 value를 사용할 수 있다.
-->

<!-- value의 값이 짝수인 경우만 출력 -->
<c:forEach var="data" items="${map}" varStatus="status">
<c:if test="${ data.value mod 2 eq 0 }">
	<h3>${ status.count } : ${ data.key } - ${ data.value }</h3>
</c:if>
</c:forEach> 

</body>
</html>