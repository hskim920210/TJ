<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 화면</title>
</head>
<body>
<h1>자유게시판</h1>

<form action="<%= request.getContextPath() %>/auth/article_write.do" method="post">
<table border="1">
<caption>게시글 작성</caption>
<tr>
	<th colspan="2">작성자 : ${ login_member.name } (${ login_member.member_id })</th>
</tr>
<tr>
	<th>글 제목</th>
	<th><input type="text" name="title" required></th>
</tr>
<tr>
	<th>내용</th>
	<th><textarea rows="30" cols="30" name="content" required></textarea></th>
</tr>
<tr>
	<th colspan="2"><input type="submit" value="작성완료"></th>
</tr>
</table>
</form>

<p><a href='<%= request.getContextPath() %>/main.do'>메인화면으로 이동</a></p>
<p><a href='<%= request.getContextPath() %>/auth/article.do'>자유게시판으로 이동</a></p>

</body>
</html>