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
		$('.odd_dan').css("color", "blue");
		$('.even_dan').css("color", "red");
	})
</script>

</head>
<body>

<h2>구구단 출력</h2>

<%-- 
c:forEach 태그의 step 속성
증가/감소의 값을 제어하는 속성
--%>

<c:forEach var="i" begin="2" end="9" step="2">

	${ style = i mod 2 eq 0 ? 'even_dan' : 'odd_dan' ; '' }

	<h3 class="${ style }">${ i } 단을 출력합니다.</h3>
		
	<c:forEach var="j" begin="1" end="9">	
		<h4 class="${ style }">${ i } * ${ j } = ${ i * j }</h4>		
	</c:forEach>	
	
</c:forEach>
</body>
</html>











