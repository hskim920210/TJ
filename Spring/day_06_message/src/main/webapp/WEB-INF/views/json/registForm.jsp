<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		
			$("#regBtn").on("click", function() {
				var mObj = new Object();
				mObj.member_id = $("#m_id").val();
				mObj.password = $("#m_pw").val();
				mObj.name = $("#m_name").val();
				mObj.rememberID = false;
				var mJsonObj = JSON.stringify(mObj);
				alert(mJsonObj);
				$.ajax({
					url : "<%= request.getContextPath() %>/json/ex_07",
					type : "post",
					data : mJsonObj,
					dataType : "json",
					contentType : "application/json",
					success : function(data) {
						alert("가입 성공");
						if(data.result == "s")
							$("#regist_result").text("회원가입 성공");
						else
							$("#regist_result").text("회원가입 실패");
					},
					error : function(data) {
						$("#regist_result").text("회원가입에 실패했습니다. (관리자에게 문의하세요.)");
					}
				});
			});
	});
	
</script>

<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

<h2>회원 정보를 입력하세요.</h2>

	<table>
		<caption>회원가입</caption>
		<tr>
			<th>아이디</th>
			<td>
				<input type='text' id='m_id' />
				<span id='regist_result' style="visibility: hidden;"></span>
			</td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><input type='password' id='m_pw' /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type='text' id='m_name' /></td>
		</tr>
		<tr>
			<th colspan='2'>
				<button id='regBtn'>가입하기</button>
			</th>
		</tr>
	</table>

</body>
</html>