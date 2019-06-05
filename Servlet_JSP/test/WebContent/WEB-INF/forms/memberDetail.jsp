<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ member.name } 님의 상세 정보 화면</title>
</head>
<body>

<h3>${ member.name } 님의 상세 정보 화면</h3>

	<table>
		<tr>
			<th>ID</th>
			<td>${ member.id }</td>
		</tr>
<!-- 			
		// 자바가 있는 스크립트릿 안에서는 el을 사용할 수 없다. jstl을 사용하면 가능
		if( login_id.equals(member.getId())) {
	
-->
	<c:if test="${ sessionScope.login_id == requestScope.member.id }" var="equal">
		<tr>
			<th>PW</th>
			<td>${ member.password }</td>
		</tr>
	</c:if>
<!-- 	} else {  -->
	<c:if test="${ !equal }">
			<th>PW</th>
			<td>로그인된 계정의 패스워드만 확인할 수 있습니다.</td>
	</c:if>
<!--  	} -->		
		<tr>
			<th>NAME</th>
			<td>${ member.name }</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td>${ member.age }</td>
		</tr>
		<tr>
			<th>TEL</th>
			<td>${ member.tel }</td>
		</tr>
		<tr>			
			<th>ADDRESS</th>			
			<td>${ member.address }</td>
		</tr>
		<tr>
			<th colspan="2">
				<a href='${pageContext.request.contextPath}/auth/member_list'>회원 목록 화면으로 이동</a>
			</th>
		</tr>
	
<!--	if( login_id.equals(member.getId())) { -->
	<c:if test="${ equal }">
		<tr>
			<th colspan="2">
				<a href='${pageContext.request.contextPath}/auth/member_update?id=${ member.id }'>[수정]</a>
				<a href='${pageContext.request.contextPath}/auth/member_delete?id=${ member.id }'>[삭제]</a>
			</th>
		</tr>
	</c:if>	
<!--  	} -->
		<tr>
			<th colspan="2">
				<a href='${pageContext.request.contextPath}/member_main'>메인화면으로 이동</a>
			</th>
		</tr>
	</table>

</body>
</html>