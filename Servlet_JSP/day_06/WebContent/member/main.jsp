<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main 페이지</title>
</head>
<body>

<%
	// 현재 접속중인 사용자 수를 세기 위한 어플리케이션의 count 속성 확인
	// null값이면 0으로 설정해준다.
	if(application.getAttribute("count") == null) {
		application.setAttribute("count", "0");
	}
	request.setCharacterEncoding("utf-8");
	// 세션에 아이디가 저장되어있는지 확인
	// 저장되어있으면 저장된 값을 불러온다.
	String id = (String)session.getAttribute("login_id");
	String name = (String)session.getAttribute("login_name");
%>

<!-- 만약 세션에 아이디가 있다면 출력될 화면 -->
<% if(id != null) { %>
	<h2>메인 메뉴</h2>
	<h3>현재 접속된 클라이언트의 수 : <%= application.getAttribute("count") %></h3>
	<ul>
		<li><a href = '<%= request.getContextPath() %>/member/list.jsp'>회원 목록 보기</a></li>
		<li><a href = '<%= request.getContextPath() %>/member/logout.jsp'>로그아웃</a></li>
	</ul>
<% } else { %>

<!-- 세션에 아이디가 없다면 출력될 화면 -->
<h2>메인 메뉴</h2>
<ul>
	<li><a href = '<%= request.getContextPath() %>/member/registForm.jsp'>회원 가입</a></li>
	<li><a href = '<%= request.getContextPath() %>/member/login.jsp'>로그인</a></li>
</ul>
<% } %>

</body>
</html>