<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tje.model.*" %>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
<%-- 아래 코드는 Member member = new Member();  --%>
<%-- request.setAttribute("member", member) 와 동일한 기능을 하는 태그--%>
<jsp:useBean id="member" class="tje.model.Member" scope="request"/>
<jsp:setProperty name="member" property="*" />


<%
	// 데이터베이스에 id와 pw가 일치하는지 확인하고
	// name 변수에 로그인에 성공한 회원의 이름을 초기화
	// 또한 로그인 실패와 성공여부를 알려주고
	// 쿠키에 아이디를 저장하여 돌려준다.
	request.setCharacterEncoding("utf-8");
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	String jdbc_id = "root";
	String jdbc_password = "SystemManager304";
	Member m = (Member)request.getAttribute("member");
	String strId = m.getId();
	String strPassword = m.getPassword();
	String name = null;
	
	Class.forName(jdbc_driver);
	Connection conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
	
	String sql = "select name from member where id = ? and password = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, strId);
	pstmt.setString(2, strPassword);
	
	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next()) {
		name = rs.getString("name");
	}
	
	rs.close();
	pstmt.close();
	conn.close();
%>

<% if(name == null) { %>
	<h2>로그인 실패</h2>
	<h4>입력된 정보를 확인하세요.</h4>
	<input type = "button" value = "메인으로" onclick = "location.href='<%= request.getContextPath() %>/member/main.jsp'">
<% } else { %>
	<h2>로그인 성공</h2>
	<h4><%= name %>님 환영합니다 !</h4>
	<% 
		session.setAttribute("login_id", strId);
		session.setAttribute("login_name", name);
	%>
	<input type = "button" value = "메인으로" onclick = "location.href='<%= request.getContextPath() %>/member/main.jsp'">
	
	<% 
	// 로그인 된 후 접속중인 인원 1 늘린다.
	Integer count = Integer.parseInt((String)application.getAttribute("count"));
	application.setAttribute("count", "" + (count+1));
	%>
<% } %>

<%
// 로그인 아이디를 저장하기 위한 쿠키 생성 
	// 체크박스의 형태를 확인하여 쿠키를 생성할지 말지 결정
	String save_id = request.getParameter("save_id");
	if(save_id != null) {
		Cookie cookie = new Cookie("save_id", strId);
		response.addCookie(cookie);
	} else if (save_id == null) {
		// 체크가 안되어있으면 save_id 속성을 만들어서 바로 지운다
		Cookie cookie = new Cookie("save_id", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
%>


</body>
</html>