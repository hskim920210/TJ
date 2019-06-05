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
varStatus 속성 : 현재 반복에 관련된 정보를 가지고 있는 
변수를 생성하고자 하는 경우 사용
varStatus에 지정된 변수를 통해서 접근할 수 있는 정보
varStatus="status" 인경우
- status.index : 0부터 시작하는 루프의 인덱스
- status.count : 현재의 반복 횟수. 1부터 시작
- status.current : 현재 사용중인 값 (var 속성의 값)
- status.first : 현재가 첫번째 루프이면 true
- status.last : 현재가 마지막 루프이면 true
- status.begin : begin  속성을 사용했을 경우 begin 의 값
- status.end : end 속성을 사용했을 경우 end 의 값
- status.step :  step 속성을 사용했을 경우 step 의 값
--%>
<c:forEach var="number" items="${list}" varStatus="status">
	<h3>${ status.index } / ${ status.count } : ${ number }</h3>	
</c:forEach>


</body>
</html>











