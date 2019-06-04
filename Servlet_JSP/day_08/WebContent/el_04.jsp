<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL을 사용한 변수 선언</title>
</head>
<body>

<h3>EL을 사용한 변수 선언 {변수명 = 값}을 사용할 수 있다.</h3>
<!-- el은 변수를 선언하면 변수가 그자리에 남아있어 출력이 되어버린다. -->
<!-- EL을 사용하여 변수를 생성하는 경우, 변수의 선언 뒤 값이 출력된다. -->
<h3>${ number = 101 }</h3>
<h3>number 변수의 값은 : ${ number }</h3>

<!-- EL을 사용하여 변수를 생성할 때 값을 출력하지 않는 방법. 공백을 둔다. -->
<h3>${ number = 505; '' }</h3>
<h3>number 변수의 값은 : ${ number }</h3>

</body>
</html>