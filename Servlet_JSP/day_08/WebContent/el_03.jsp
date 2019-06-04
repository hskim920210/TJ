<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="tje.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL을 활용한 객체의 접근</title>
</head>
<body>

<%
	HashMap<String, Integer> map = new HashMap<>();
	map.put("One", 1);
	map.put("Two", 2);
	map.put("Three", 3);
	
	// EL 언어를 사용하여 접근하는 모든 객체들은
	// 반드시 특정 영역 내부에 저장되어야만 한다.
	request.setAttribute("map", map);
	
	/*
	접근할 객체의 타입이 배열, 리스트 타입인 경우 반드시 정수만 사용할 수 있다.
	<h3>list 객체의 a 키 값에 접근 : ${ list.a }</h3>
	*/
	ArrayList<String> list = new ArrayList<>();
	list.add("One");
	list.add("Two");
	list.add("Three");
	request.setAttribute("list", list);
	
	Member member = new Member();
	member.id="abc";
	member.password="def";
	member.name="아무개";
	request.setAttribute("member", member);
%>

<!-- page, request, session, application을 돌면서 map객체가 있는지 확인한다. -->
<!-- 그래서 requestScope를 굳이 안써도 된다. -->
<h3>map1 객체의 One 키 값에 접근 : ${ map1.One }</h3>
<h3>map 객체의 One 키 값에 접근 : ${ map.One }</h3>
<h3>map 객체의 Two 키 값에 접근 : ${ map.Two }</h3>
<h3>map 객체의 Three 키 값에 접근 : ${ map.Three }</h3>
<h3>map 객체의 Four 키 값에 접근 : ${ map.Four }</h3>


<h3>list 객체의 0 키 값에 접근 : ${ list[0] }</h3>
<h3>list 객체의 1 키 값에 접근 : ${ list[1] }</h3>
<h3>list 객체의 2 키 값에 접근 : ${ list[2] }</h3>

<!-- 클래스에서 아무리 public으로 필드를 선언해도 겟터가 없으면 프로퍼티 낫 파운드 익셉션 -->
<h3>member 객체의 id에 접근 : ${ member.id }</h3>
<h3>member 객체의 password에 접근 : ${ member.password }</h3>
<h3>member 객체의 name에 접근 : ${ member.name }</h3>


</body>
</html>