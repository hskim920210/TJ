<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 기능</title>
</head>
<body>

<h2>main 페이지의 내용 1</h2>


<jsp:include page="/include/jsp_26_sub.jsp" flush="false"/>

<h2>main 페이지의 내용 2</h2>
  



</body>
</html>