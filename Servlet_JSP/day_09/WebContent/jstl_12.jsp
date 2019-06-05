<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 반복문</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('.odd_dan').css("color", "green");
		$('.even_dan').css("color", "yellow");
	})
</script>

</head>
<body>

<h2>구구단 출력</h2>

<%-- 
c:forEach 태그의 var 속성
현재 제어되고 있는 값을 저장할 변수명을 지정하는 속성
var="num" begin="1" end="3" 이러한 경우
num 변수는 첫번째 반복시 1의 값
마지막 반복시 3의 값을 가집니다.
--%>

<c:forEach var="i" begin="2" end="9">

	${ style = i mod 2 eq 0 ? 'even_dan' : 'odd_dan' ; '' }

	<h3 class="${ style }">${ i } 단을 출력합니다.</h3>
		
	<c:forEach var="j" begin="1" end="9">	
		<h4 class="${ style }">${ i } * ${ j } = ${ i * j }</h4>		
	</c:forEach>	
	
</c:forEach>
</body>
</html>











