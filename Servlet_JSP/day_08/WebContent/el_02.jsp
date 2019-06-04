<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL의 기본 영역 객체 활용</title>
</head>
<body>

<h3>REQUEST 영역에 저장된 id 속성의 값을 출력(표현식) : <%= request.getAttribute("id") %></h3>
<h3>REQUEST 영역에 저장된 id 속성의 값을 출력(EL) : ${ requestScope.id }</h3>

<h3>SESSION 영역에 저장된 id 속성의 값을 출력(표현식) : <%= session.getAttribute("password") %></h3>
<h3>SESSION 영역에 저장된 id 속성의 값을 출력(EL) : ${ sessionScope.password }</h3>

<h3>APPLICATION 영역에 저장된 id 속성의 값을 출력(표현식) : <%= application.getAttribute("name") %></h3>
<h3>APPLICATION 영역에 저장된 id 속성의 값을 출력(EL) : ${ applicationScope.name }</h3>

<h3>DUMMY 영역에 저장된 age 속성의 값을 출력(EL) : ${dummy.age}</h3>
</body>
</html>