<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 화면</title>

<script type="text/javascript" src='<%=request.getContextPath()%>/js/jquery.js'></script>

<script type="text/javascript">
	// 서버에서 실행되는 EL 의 결과 값을 사용하여
	// 자바스크립트 변수의 값을 초기화하는 코드
	var comment_count = ${commentSize};
	// 자바스크립트 함수 정의
	// 댓글을 지우기위한 버튼이 클릭될 때 
	// 실행될 함수
	// (비동기 통신 (AJAX) 방법을 사용하여 서버와 데이터를 송수신)
	function delete_comment(comment_id) {
		// ajax 정의 코드
		// 화면의 전환없이 내부에 정의된 url 경로로 요청이 실행
		// (웹 브라우저의 현재 URL 정보가 변경되지 않음)
		$.ajax({
			// 비동기 방식으로 데이터를 전송할 주소
			url:'<%=request.getContextPath()%>/auth/delete_comment.do',
			// 메소드 호출 방식
			type:"post",
			// 서버쪽에 전달하는 문자열 데이터의 인코딩 처리
			// 폼데이터의 인코딩 처리
			contentType: 
				"application/x-www-form-urlencoded; charset=utf-8",
			// 서버에 전달할 데이터
			// 키=값의 형태를 사용
			// (쿼리스트링을 사용, 아래와 같이 단일 값이 아닌
			// 다수개의 값을 전달하는 경우 키1=값1&키2=값2 ...)
			data:"comment_id=" + comment_id,
			// 서버로부터 전달받을 데이터의 유형
			// text, xml, json ...
			dataType:"text",
			// 데이터 송수신이 성공한 경우 실행할 함수
			// (매개변수에는 서버에서 전송하는 값을 전달받을 수 있음)
			success:function(result){			
				// true/false 값이 result 변수에
				// 대입된 후, eval 함수를 통해서
				// 분기문을 실행
				if( eval(result) ) {						
					var selector = '#comment_' + comment_id
					$(selector).remove();
					alert('댓글(' + comment_id + ') 삭제 완료!');	
					
					comment_count -= 1;
					$("#comment_count").text(comment_count);
					
					if( comment_count == 0 ) {
						$("#comment_table").remove();
						$("#comment_area").append("<h4>댓글이 존재하지 않습니다.</h4>");
					}
				} else {
					alert('댓글 삭제과정에서 문제 발생');		
				}
					
			},
			// ajax 호출이 실패한 경우 실행되는 함수
			error:function(result){
				alert('댓글 삭제과정에서 문제 발생');					
			}
		});
	}
	
	function insert_comment() {
		// 특정 폼 내부의 모든 데이터를 직렬화하여 변수로 저장		
		var comment_data = $("#comment_form").serialize();
		alert(comment_data)
		
		$.ajax({
			url:'<%=request.getContextPath()%>/auth/write_comment.do',
			type:"post",		
			contentType: 
				"application/x-www-form-urlencoded; charset=utf-8",
			data: comment_data,
			dataType:"json",
			success:function(result){			
				// JSON 데이터 포멧으로 구성된 result 변수에서
				// 값을 추출
				//alert(result)		
				
				if( eval(result.result) ) {
					var commentTag = "<tr id='comment_" + result.comment_id + "''>";
					commentTag += "<td>" + result.member_id + "</td>";
					commentTag += "<td>" + result.content + "</td>";					
					commentTag += "<td>" + result.date + "</td>";
					commentTag += "<td>";
					commentTag += "<button onclick='delete_comment(" + result.comment_id + ");'>삭제</button>";					
					commentTag += "</td>";
					commentTag += "</tr>";
					$("#comment_table").append(commentTag);
					comment_count += 1;
					$("#comment_count").text(comment_count);
				} else {
					alert('댓글 작성에서 문제 발생');	
				}
				
			},
			// ajax 호출이 실패한 경우 실행되는 함수
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("error "+(new Date()));
		        var errorMsg = 'status(code): ' + jqXHR.status + '\n';
		        errorMsg += 'statusText: ' + jqXHR.statusText + '\n';
		        errorMsg += 'responseText: ' + jqXHR.responseText + '\n';
		        errorMsg += 'textStatus: ' + textStatus + '\n';
		        errorMsg += 'errorThrown: ' + errorThrown;

		        console.log(errorMsg);
		        
				alert('댓글 작성에서 문제 발생');					
			}
		});
	}
</script>

</head>
<body>

<table border="1">		
	<tr>
		<td>${ detailArticle.article_id }</td>
		<td>${ detailArticle.name }(${ detailArticle.member_id })</td>
		<td>${ detailArticle.title }</td>
		<td>${ detailArticle.write_timeString }</td>			
		<td>${ detailArticle.read_count }</td>
	</tr>
	<tr>
		<td colspan="5">${ detailArticle.content }</td>			
	</tr>		
</table>

<c:if test="${ login_member.member_id eq detailArticle.member_id }">
	<div>
	<a href='<%=request.getContextPath()%>/auth/update_article.do?article_id=${ detailArticle.article_id }'>[수정]</a>
	<a href='<%=request.getContextPath()%>/auth/delete_article.do?article_id=${ detailArticle.article_id }'>[삭제]</a>
	</div>
</c:if>

<h3>댓글 <span id="comment_count">${commentSize}</span></h3>
<form id="comment_form" action="<%= request.getContextPath() %>/auth/write_comment.do" method="post">
	<input type="hidden" name="article_id" value="${ detailArticle.article_id }">
	<textarea rows="3" cols="20" name="content"></textarea>	
	<input type="button" value="댓글등록" onclick="insert_comment();">
</form>

<div id="comment_area">
<c:if test="${ not empty commentList }" var="r">
<!-- 댓글 목록을 출력.... -->
<table border="1" id="comment_table">	
	<c:forEach items="${ commentList }" var="comment">
		<tr id="comment_${comment.comment_id}">
			<td>${ comment.member_id }</td>
			<td>${ comment.content }</td>
			<td>${ comment.write_timeString }</td>
			<td>
			<c:if test="${ login_member.member_id eq comment.member_id }">
			
<button onclick="delete_comment(${comment.comment_id});">삭제</button>
				
			</c:if>
			</td>
		</tr>
	</c:forEach>	
</table>
</c:if>
<c:if test="${ not r }">
	<h4>댓글이 존재하지 않습니다.</h4>
</c:if>
</div>

<p><a href='<%=request.getContextPath()%>/main.do'>메인화면</a></p>
<p><a href='<%=request.getContextPath()%>/auth/article.do'>자유게시판</a></p>

</body>
</html>







