<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 처리 페이지</title>
</head>
<body>

<h1 style="color:red">에러가 발생했습니다.</h1>

<h3>(발생한 에러 : <%= exception.getClass().getName() %>)</h3>

</body>
</html>