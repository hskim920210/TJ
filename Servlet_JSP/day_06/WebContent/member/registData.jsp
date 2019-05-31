<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="java.sql.*"%>
<%@ page import="tje.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 아래 코드는 Member member = new Member();  --%>
<%-- request.setAttribute("member", member) 와 동일한 기능을 하는 태그--%>
<jsp:useBean id="member" class="tje.model.Member" scope="request"/>
<jsp:setProperty name="member" property="*" />

<!-- 데이터베이스에 Member의 정보를 넣어준다. -->
<%
	request.setCharacterEncoding("utf-8");
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	String jdbc_id = "root";
	String jdbc_password = "SystemManager304";
	Member m = (Member)request.getAttribute("member");
	int registResult = 0; 
	
	Class.forName(jdbc_driver);
	Connection conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
	
	String sql = "insert into member values (?,?,?,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, m.getId());
	pstmt.setString(2, m.getPassword());
	pstmt.setString(3, m.getName());
	try{
	pstmt.setInt(4, m.getAge());
	} catch(Exception e) {
		out.println("나이를 잘못입력했습니다.");
	}
	if( m.getTel() != null ) {
		pstmt.setString(5, m.getTel());
	} else {
		pstmt.setNull(5, Types.NULL);		
	}
	if( m.getAddress() != null ) {
		pstmt.setString(6, m.getAddress());
	} else {
		pstmt.setNull(6, Types.NULL);		
	}
	
	try{
		registResult = pstmt.executeUpdate();
	} catch (Exception e) {
		
	}
	
	pstmt.close();
	conn.close();
%>

<!-- 회원가입이 실패한 경우 (registResult = 0) -->
<% 
	request.setCharacterEncoding("utf-8");
	if(registResult == 0) { %>
	<h2>회원가입 실패</h2>
	<h4>입력된 정보를 확인하세요.</h4>
	<p>ID : <%= m.getId() %></p>
	<p>Password : <%= m.getPassword() %></p>
	<p>Name : <%= m.getName() %></p>
	<p>Age : <%= m.getAge() %> (나이가 잘못 입력된 경우 0으로 표시됨)</p>
	<p>Tel : <%= m.getTel() %></p>
	<p>Address : <%= m.getAddress() %></p>
<% } %>

<!-- 회원가입이 성공한 경우 (registResult = 1) -->
<% if(registResult == 1) { %>
<h2>회원가입 성공</h2>
<input type="button" value="메인으로" onclick="location.href='<%= request.getContextPath() %>/member/main.jsp'">
<% } %>


</body>
</html>