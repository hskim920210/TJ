<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>

<jsp:useBean id="member" class="tje.model.Member" scope="request"/>
<jsp:setProperty name="member" property="*" />

<%
	request.setCharacterEncoding("utf-8");
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	String jdbc_id = "root";
	String jdbc_password = "SystemManager304";
	
	Connection conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
	
	String sql = "select * from member";
	Statement stmt = conn.createStatement();
	ResultSet rs = null;
	rs = stmt.executeQuery(sql);
%>
<table border="1" width="700px">
	<tr style="background-color: silver">
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>연락처</th>
	</tr>
<%	
	while(rs.next()) { %>
	<tr>
		<td><%= rs.getString("id") %></td>
		<td><%= rs.getString("name") %></td>
		<td><%= rs.getString("age") %></td>
		<td><%= rs.getString("tel") %></td>
	</tr>	
	<% }
	rs.close();
	stmt.close();
	conn.close();
%>
</table>
	<input type = "button" value = "메인으로" onclick = "location.href='<%= request.getContextPath() %>/member/main.jsp'">
</body>
</html>