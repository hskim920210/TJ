<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 화면</title>
</head>
<body>

<table border="1">		
	<tr>
		<td>${ detailArticle.article_id }</td>
		<td>${ detailArticle.name }(${ detailArticle.member_id })</td>
		<td>${ detailArticle.title }</td>
		<td>${ detailArticle.write_timeString }</td>			
	</tr>
	<tr>
		<td colspan="4">${ detailArticle.content }</td>			
	</tr>		
</table>

<!-- 댓글 목록을 출력.... -->

<p><a href='<%=request.getContextPath()%>/main.do'>메인화면</a></p>
<p><a href='<%=request.getContextPath()%>/auth/article.do'>자유게시판</a></p>

</body>
</html>