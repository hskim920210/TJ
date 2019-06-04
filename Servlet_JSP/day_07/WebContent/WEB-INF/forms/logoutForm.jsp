<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp 내부에서 jdbc 프로그래밍을 위한 java.sql 패키지를 import -->
<%@ page import="java.sql.*" %>

<%!
	// <% 안에 메소드 내부에 사용될 변수이므로 private이 안된다.
	// <%! 에선 메소드정의하므로 된다.
	// 선언부를 사용하여 멤버 변수를 선언하는 코드
	// (jdbc를 사용하기 위한 기본 정보를 저장하는 변수)
	private static String jdbc_url;
	private static String jdbc_id;
	private static String jdbc_password;
	
%>
<%
	// web.xml에 기록된 정보를 추출하는 코드
	// (application 객체를 사용)
	jdbc_url = application.getInitParameter("JDBC_URL");
	jdbc_id = application.getInitParameter("JDBC_ID");
	jdbc_password = application.getInitParameter("JDBC_PASSWORD");
	
	// 현재 로그인된 사용자의 id 값을 session으로부터 반환
	String id = (String)session.getAttribute("login_id");
	// 현재 로그인된 사용자의 이름을 저장하는 변수
	// (데이터베이스로부터 검색하여 값을 설정)
	String name = null;
	
	// JDBC를 사용한 데이터베이스 처리
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
		String query = "select * from member where id = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if( rs.next() ) {
			// 세션에 저장된 아이디를 통해 테이블의 name을 추출하는 코드
			name = rs.getString("name");
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	try {
		if( conn != null ) {conn.close();}
		if( pstmt != null ) {pstmt.close();}
		if( rs != null ) {rs.close();}
	} catch(Exception e) {
		e.printStackTrace();
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 페이지</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/member_logout" method="post">
	<!-- 히든은 사용자 눈에 보이지 않지만 로그아웃 서블릿에서 name을 넘겨받기 위해 이렇게 설정한다. -->
	<input type="hidden" name="name" value="<%= name%>">
	<h3>'<%= name %>' 님 로그아웃 하시겠습니까?</h3>
	<input type="submit" value="로그아웃">
</form>

<p><a href='<%= request.getContextPath() %>/member_main'>메인화면으로 이동</a></p>

</body>
</html>