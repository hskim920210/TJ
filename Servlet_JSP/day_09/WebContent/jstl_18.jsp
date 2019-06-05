<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 문자열 타입의 반복문</title>
</head>
<body>

<%
	String scores = "100,90,88";
	pageContext.setAttribute("scores", scores);
%>

<h2>문자열 파싱 기능을 제공하는 태그 활용</h2>
<!-- 
문자열을 구분문자를 사용하여 추출할 수 있는 c:forTokens 태그
-->
<!-- items는 내가 파싱해야할 데이터, var는 파싱된걸 저장하는거 -->

<c:forTokens var="score" items="${ scores }" delims="," varStatus="status" >
	<h3>${ status.count } 번째 성적 : ${ score }</h3>
</c:forTokens>

<!-- 총점과 평균 출력 -->
<c:set var="tot" ></c:set>
<c:set var="avg" ></c:set>
<c:forTokens var="score" items="${ scores }" delims="," varStatus="status" >
	${ tot = tot + score;'' }
	<c:if test="${ status.last }">
		${ avg = tot div status.count;'' }
	</c:if>
</c:forTokens>

<h3>총점은 ${ tot } 점 입니다.</h3>
<h3>${ String.format("평균 : %.2f 점", avg) }</h3>


<!-- 선생님 코드 
${ sum = 0.0 ; avg = 0.0 ; '' }
<c:forTokens var="score" items="${ scores }" delims="," varStatus="status">
	<h3>${ status.count } 번째 성적 : ${ score }</h3>
	${ sum = sum + score ; '' }
</c:forTokens>
${ avg = sum / 3 ; '' }
\ 총점과 평균 \
<h3>총점 : ${ sum } 점</h3>
<h3>${ String.format("평균 : %.2f 점", avg) }</h3>
-->

</body>
</html>