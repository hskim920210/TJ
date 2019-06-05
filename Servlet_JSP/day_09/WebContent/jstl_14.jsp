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
	ArrayList<Integer> list = new ArrayList<>();
	for( int i = 1 ; i <= 10 ; i++)
		list.add(i*10);
	pageContext.setAttribute("list", list);
%>

<h2>리스트의 내용 출력</h2>

<%-- 
특정 리스트, 맴을 순회하기 위한 c:forEach 태그
items 속성에 반복을 통해서 값을 추출할 컬렉션 객체를 입력
var 속성에 기술된 변수명으로 items의 컬렉션이 가진 데이터가
수차적으로 하나씩 대입되어 반복이 수행
--%>
<c:forEach var="number" items="${list}">
	<h3>number : ${ number }</h3>	
</c:forEach>

<c:forEach var="i" begin="0" end="${ list.size() - 1 }" >	
	<h3>list[${i}] : ${ list[i] }</h3>		
</c:forEach>

</body>
</html>











