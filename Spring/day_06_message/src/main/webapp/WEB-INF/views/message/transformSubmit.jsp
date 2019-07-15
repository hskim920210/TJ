<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메세지 작성</title>
</head>
<body>


<h3>'${ loginMember.name }' 님이 작성한 메세지(${ message_id })가  '${ message.receiver }' 님에게 전송되었습니다.</h3>
<h4><a href="<%= request.getContextPath() %>">시작 화면으로 이동</a></h4>
<h4><a href="<%= request.getContextPath() %>/message/transform">새로운 메세지 작성하기</a></h4>

</body>
</html>