<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

<!-- 쿠키 객체를 생성한다.  -->
<%
	request.setCharacterEncoding("utf-8");
	Cookie [] cookies = request.getCookies();
	//저장된 id가 있는지 확인한다.
	String save_id = null;
	for(int i = 0 ; cookies != null && i < cookies.length ; i++) {
		if(cookies[i].getName().equals("save_id")) {
			save_id = cookies[i].getValue();
		}
	}
	boolean saved = (save_id != null);
%>

<!-- 세션을 확인해서 로그인이 되어있는지 확인한다. -->
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("login_id");
	boolean logged = false;
	if(id != null) {
		logged = true;
	}
%>

<!-- 세션에 아이디가 없는 경우 출력될 부분 -->
<% if( !logged ) { %>
	<form action="<%= request.getContextPath() %>/member/loginData.jsp" method="post">
	<table>
			<caption>로그인</caption>
			<tr>
				<th>ID</th>
				<th>PW</th>			
			</tr>
			<tr>
			<!-- 쿠키가 있을 때 -->
			<% if (saved) { %>
					<td><input type="text" name="id" value = "<%= save_id %>" required></td>
			<% } else { %>	
				<td><input type="text" name="id" required></td>
			<% } %>	
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="로그인"></th>
			</tr>
			<tr>
			<% if(saved) { %>
				<th colspan="2"><label>아이디 저장<input type = "checkbox" name = "save_id" checked></label></th>
			<% } else { %>	
				<th colspan="2"><label>아이디 저장<input type = "checkbox" name = "save_id"></label></th>
			<% } %>
			</tr>
		</table>
	</form>
	
	<form action = "<%= request.getContextPath() %>/member/main.jsp" method="get">
	<p><input type = "submit" value = "메인으로"></p>
	</form>
<% } else if (logged) { %>
	<h3><%= id %> 님은 로그인 상태입니다.</h3>
	<input type = "button" value = "메인으로" onclick = "location.href='<%= request.getContextPath() %>/member/main.jsp'">
<% } %>


</body>
</html>