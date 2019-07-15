<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#jsonBtn").on("click", function() {
			var memberObject = new Object();
			memberObject.member_id = $("#member_id").val();
			memberObject.password = $("#member_password").val();
			memberObject.name = $("#member_name").val();
			// 자바스크립트의 JSON 문서 생성 방법
			var memberJsonObject = JSON.stringify(memberObject);
			alert(memberJsonObject);
			$.ajax({
				url : "<%= request.getContextPath() %>/json/ex_05",
				type : "post",
				data : memberJsonObject,
				dataType : "json",
				contentType : 'application/json',
				success : function(data) {
					alert("success");
				},
				error : function(data) {
					alert("error");
					//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		});
	});
	
</script>
<meta charset="UTF-8">
<title>JQUERY를 활용한 JSON 객체 생성 및 서버 전달</title>
</head>
<body>

<h3>아이디 : <input type='text' id='member_id'></h3>
<h3>패스워드 : <input type='text' id='member_password'></h3>
<h3>이름 : <input type="text" id="member_name"></h3>

<p><button id='jsonBtn'>JSON 문서 생성 및 서버 전달</button></p>

</body>
</html>