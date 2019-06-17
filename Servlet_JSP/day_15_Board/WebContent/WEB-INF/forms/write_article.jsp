<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 화면</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/auth/article_write.do" method="post">
	<table>
		<caption>게시글 작성</caption>
		<tr>
			<th>작성자</th>
			<td>${ login_member.name }(${ login_member.member_id })</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" required></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="30" cols="30" name="content" required></textarea></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="작성"></th>
		</tr>
	</table>
</form>

<p><a href='<%=request.getContextPath()%>/main.do'>메인화면</a></p>
<p><a href='<%=request.getContextPath()%>/auth/article.do'>자유게시판</a></p>

</body>
</html>