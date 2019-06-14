<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 화면</title>
</head>
<body>

<h3>자유게시판</h3>

<table border="1px">

<tr>
	<th>게시글번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성날자</th>
	<th>조회수</th>
</tr>

<c:if test="${ empty articleList }" var="r" >
	<tr>
	<th colspan="5"><h4>게시글이 존재하지 않습니다.</h4></th>
	</tr>
</c:if>

<c:if test="${ not r }">
	
	<c:forEach items="${ articleList }" var="article">
		<tr>
		<th>${ article.article_id }</th>
		<th><a href='<%=request.getContextPath()%>/auth/article_detail.do?article_id=${ article.article_id }'>${ article.title }</a></th>
		<th>${ article.name }</th>
		<th>${ article.write_timeString }</th>
		<th>${ article.read_count }</th>
		</tr>
	</c:forEach>
	
</c:if>
</table>

<p>[<a href='<%=request.getContextPath()%>/auth/article_write.do'>게시글 작성</a>]</p>

<form action="<%= request.getContextPath() %>/auth/article.do" method="post">
<select name="searchItem">
	<option value="title" selected>글제목</option>
	<option value="name">작성자</option>
</select>
<input type="text" size="20" name="searchValue">
<input type="submit" value="검색">
</form>

<p><a href='<%= request.getContextPath() %>/main.do'>메인화면으로 이동</a></p>

</body>
</html>









