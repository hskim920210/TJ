<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>


<p>회원 가입을 완료했습니다.</p>
<p><strong>${ registerRequest.name } 님은  ${ insertedKey } 번째 회원입니다.</strong></p>
<p>${ param.name } 파람에서의 이름</p>
<p><a href="<c:url value='/'/>">[첫 화면 이동]</a></p>


</body>
</html>