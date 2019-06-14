<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 확인 인증 결과 화면</title>
</head>
<body>

<h3>'${ login_member.name }'님의 인증이 성공하였습니다. 아래의 링크를 클릭하세요.</h3>
<h3><a href='<%= request.getContextPath() %>/auth/member_detail.do'>개인정보 확인 화면으로 이동</a></h3>

<p><a href='<%= request.getContextPath() %>/main.do'>메인화면으로 이동</a></p>

</body>
</html>






