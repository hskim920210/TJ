<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL을 활용한 객체의 메소드 호출</title>
</head>
<body>

<h3>member 객체의 id : ${ member.id }</h3>
<h3>member 객체의 password : ${ member.password }</h3>
<!-- EL을 사용하여 특정 객체가 가지고 있는 메소드를 호출할 수 있다. -->
<!-- 메소드의 반환 값을 화면에 출력하는 예제 -->
<h3>member 객체의 name : ${ member.getName() }</h3>
<!-- 메소드의 반환 값이 없기 때문에 화면에 출력되지 않는 예제 -->
${ member.printInfo() }

</body>
</html>