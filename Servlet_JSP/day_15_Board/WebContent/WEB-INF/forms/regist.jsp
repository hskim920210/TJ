<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.js"></script>

<script type="text/javascript">
	var isCheckID = false;
	$(function () {
		$("#idCheckBtn").on("click", function () {
			// 체크할 현재 입력된 ID의 값을 추출
			var member_id = $("#member_form [name='member_id']").val();
			
			$.ajax({
				// 비동기 방식으로 데이터를 전송할 주소
				url:'<%=request.getContextPath()%>/check_id.do',
				// 메소드 호출 방식
				// 어차피 get이나 post나 눈으로 티는 안나긴 한다.
				type:"post",
				// 서버쪽에 전달하는 문자열 데이터의 인코딩 처리
				// 폼 데이터의 인코딩 처리이므로 지금은 이부분이 없어도 상관은 없다.
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				// 서버에 전달할 데이터
				// 키=값의 형태 사용
				// (쿼리 스트링을 사용, 아래와 같이 단일 값이 아닌 다수 값을 전달하는 경우
				//	키1=값1&키2=값2%...)
				data:"member_id=" + member_id,
				// 서버로부터 전달받은 데이터의 유형
				// text, xml, json
				dataType:"text",
				// 데이터 송수신이 성공할 경우 실행할 함수
				// (매개변수에는 서버에서 전송하는 값을 전달받을 수 있다.)
				success:function (result){
					// true/false 값이 result 변수에 대입된 후,
					// eval 함수를 통해 분기문을 실행
					var msg='';
					if( eval(result) ){
						alert('이미 존재하는 ID 입니다.');
						msg='이미 존재하는 ID 입니다.';
						
					} else {
						alert('사용할 수 있는 ID 입니다.');
						msg='사용할 수 있는 ID 입니다.';
						isCheckID = true;
					}
					$("#checkIDArea").text(msg);
				},
				error:function(result){
					alert('ID 체크 과정에서 문제 발생');
				} 
			
			});
		});
	});
</script>

</head>
<body>

<form id="member_form" action="<%= request.getContextPath() %>/regist.do" method="post">
	<table>
		<caption>회원가입</caption>
		<tr>
			<th>ID</th>
			<td><input type="text" name="member_id" required>
			<button id="idCheckBtn">ID중복체크</button> 
			<span id="checkIDArea">
			</span>
			${ errorMsg } </td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name" value="${ param.name }" required></td>
		</tr>
		<tr>
			<th>GENDER</th>
			<td>
			<label>남성<input type="radio" name="gender" value="1" ${ empty param.gender or param.gender eq 1 ? 'checked' : '' }></label>
			<label>여성<input type="radio" name="gender" value="2" ${ not empty param.gender and param.gender eq 2 ? 'checked' : '' }></label>
			</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td><input type="text" name="age" value="${ param.age }"></td>
		</tr>
		<tr>
			<th>BIRTH</th>
			<td>
			년 : <input type="text" size="4" name="year" value="${ param.year }">
			월 : <input type="text" size="2" name="month" value="${ param.month }">
			일 : <input type="text" size="2" name="day" value="${ param.day }">
			</td>
		</tr>
		<tr>
			<th>TEL</th>
			<td><input type="text" name="tel" value="${ param.tel }"></td>
		</tr>
		<tr>
			<th>ADDRESS</th>	
			<td><input type="text" name="address" value="${ param.address }"></td>		
		</tr>		
		<tr>
			<th colspan="2"><input type="submit" value="가입"></th>
		</tr>
	</table>
</form>

</body>
</html>