<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	JSTL 라이브러리
	커스텀 태그 중 유용하게 사용하는 몇몇 태그들을 표준화 시킨 것
	외부에서 정의된 태그를 사용하는 라이브러리
 
 	외부의 라이브러리를 활용하기 때문에 taglib 디렉티브를 선언해야만 사용할 수 있다.
 	아래의 taglib 디렉티브는 코어 JSTL 라이브러리를 사용하기 위한 선언문
 	(반드시 JSTL 라이브러리를 WEB-INF 내부의 lib 디렉토리로 복사한 후 사용해야한다.)
 --%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 활용 - 변수의 선언 (특정 영역에 변수를 생성)</title>
</head>
<body>

<% 
	// 스크립트렛 내부에서 선언된 변수는 메소드 내부에 선언되는 지역변수이다.
	// 지역변수는 EL을 사용하여 접근할 수 없다.
	// 이 때 사용하는게 JSTL의 set
	String localVariable = "스크립트렛 내부에서 생성된 변수";
%>
<h3>localVariable : ${ localVariable }</h3>

<!-- 
	c:set 태그
	- 변수를 생성하는 태그
	- 변수의 생성을 특정 영역 객체 내부에 생성하는 역할
	- 기본 영역은 page 영역
	- 만약 생성되는 영역을 제어하고자 하는 경우
	  scope 속성을 사용할 수 있다. (page, request, session, application)
	  
	아래의 코드는 다음과 같이 기존의 스크립트렛에서 실행할 수 있다.
	pageContext.setAttribute("pageVariable", "c:set 태그에서 생성된 변수");
 -->

<c:set var="pageVariable" value="c:set 태그에서 생성된 변수" />
<h3>pageVariable : ${ pageVariable }</h3>
<h3>pageVariable : ${ pageScope.pageVariable }</h3>

<c:set var="requestVariable" value="c:set 태그에서 request 영역에 생성된 변수" scope="request" />
<h3>requestVariable : ${ pageScope.requestVariable }</h3>
<h3>requestVariable : ${ requestScope.requestVariable }</h3>

</body>
</html>