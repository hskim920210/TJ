<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="msg" value="회원정보 수정이 완료되었습니다."/>
<c:if test="${ result == 0 }">
<c:set var="msg" value="회원정보 수정에 실패했습니다.(패스워드를 확인하세요.)"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ member.name } 님의 정보수정 결과</title>
</head>
<body>

<h3>${ member.name } 님의 ${ msg }</h3>

<p><a href='${pageContext.request.contextPath}/auth/member_detail?id=${ member.id }'>상제정보화면으로 이동</a></p>
<p><a href='${pageContext.request.contextPath}/member_main'>메인화면으로 이동</a></p>

</body>
</html>