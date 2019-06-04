<%@page import="tje.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 삭제</title>
</head>
<body>

<%
	Member member = (Member)request.getAttribute("member");
%>

<h3>회원 정보 삭제를 위해 비밀번호를 입력하세요.</h3>
<form action="./member_delete" method="post">
<input type="hidden" name = "id" value="<%=member.getId()%>">
<input type="password" name="confirmPw">
<input type="hidden" name="password" value="<%=member.getPassword()%>">
<input type="hidden" name = "name" value="<%=member.getName()%>">
<input type="hidden" name = "age" value="<%=member.getAge()%>">
<input type="hidden" name = "tel" value="<%=member.getTel()%>">
<input type="hidden" name = "address" value="<%=member.getAddress()%>">
<input type="submit" value="삭제하기">
</form>

</body>
</html>