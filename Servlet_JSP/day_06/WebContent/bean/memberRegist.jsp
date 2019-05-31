
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tje.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리 화면</title>
</head>
<body>

<%-- 아래 코드는 Member member = new Member();  --%>
<%-- request.setAttribute("member", member) 와 동일한 기능을 하는 태그--%>
<jsp:useBean id="member" class="tje.model.Member" scope="request"/>
<jsp:setProperty name="member" property="*" />

<%
	Member m = (Member)request.getAttribute("member");
	out.println(m.getId() + "<br>");
	out.println(m.getName() + "<br>");
	out.println(m.getAge() + "<br>");
	out.println(m.getTel() + "<br>");
	out.println(m.getAddress() + "<br>");

// 입력받은 폼 정보를 하나의 클래스로 모아 데이터로 저장시키는 단위 bean이라 한다.

/*
	String strId = request.getParameter("id").trim();
	String strPw = request.getParameter("password").trim();
	String strName = request.getParameter("name").trim();
	String strAge = request.getParameter("age").trim();
	String strTel = request.getParameter("tel").trim();
	String strAddress = request.getParameter("address").trim();
	
	Member member = new Member();
	member.setId(strId);
	member.setPassword(strPw);
	member.setName(strName);
	member.setAge(Integer.parseInt(strAge));
	member.setTel(strTel);
	member.setAddress(strAddress);
	
	request.setAttribute("member", member);
*/
%>

</body>
</html>