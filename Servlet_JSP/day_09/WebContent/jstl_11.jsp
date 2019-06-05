<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 반복문</title>
<!-- 
<style type="text/css">	
	.odd_dan {
		color: red;
	}
	.even_dan {
		color: blue;
	}	
</style>

-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function () {
	$('.odd_dan').css("color", "blue");
	$('.even_dan').css("color", "silver");
	
})
</script>

</head>
<body>


<h3>구구단 출력</h3>
<c:set var="num" value="2"></c:set>
<c:set var="num1" value="1"></c:set>
<c:forEach begin="1" end="8" >

	<h2 style=color:red>${ num }단 출력</h2>
	${ num1 = 1 ; '' }
	
	<c:forEach begin="1" end="9">
		
		<h3>${ num } X ${ num1 } = ${ num * num1 }</h3>
		${ num1 = num1 + 1 ; '' }
		
	</c:forEach>
	
	${ num = num + 1 ; '' }
	
	<h2>-----------------------------------</h2>

</c:forEach>


<!-- ////////////선생님 코드 /////////////////// -->

<h2>구구단 출력</h2>

<c:set var="outer">2</c:set>
<c:forEach begin="2" end="9">
	${ style = outer mod 2 eq 0 ? 'even_dan' : 'odd_dan' ; '' }
	
	<h3 class="${ style }">${ outer } 단을 출력합니다.</h3>

	<c:set var="inner">1</c:set>
	
	<c:forEach begin="1" end="9">	
	
		<h4 class="${ style }">${ outer } * ${ inner } = ${ outer * inner }</h4>
		${ inner = inner + 1 ; '' }
		
	</c:forEach>
	
	${ outer = outer + 1 ; '' }
</c:forEach>

</body>
</html>