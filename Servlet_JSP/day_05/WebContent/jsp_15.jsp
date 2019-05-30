<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 객체 활용</title>
</head>
<body>

<%
	// 원격지에 접속한 클라이언트의 주소를 가져옴
	String client = request.getRemoteHost();
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	String logMsg = String.format("%s 의 주소에서 %s 시간에 접속함", client, sdf.format(now));
	
	// 아래의 디렉토리는 사용하는 서블릿 컨테이너, 개발도구에 따라 서로 다른 경로에 생성된다.
	// File dir = new File("./log");
	
	// 만약 특정 디렉토리, 파일의 경로를 현재 웹 어플리케이션이 실행되고 있는
	// 장소를 기준으로 접근하려면 application 객체가 제공하는
	// getRealPath 메소드를 사용할 수 있다.
	// 아래의 application.getRealPath("/WEB-INF") 코드는
	// 현재 웹 어플리케이션이 실행되고 있는 경로의 WEB-INF 디렉토리의
	// 절대 경로 값을 반환한다.
	File dir = new File(application.getRealPath("/WEB-INF"), "log");
	if( !dir.exists() ) {
		dir.mkdirs();
	}
	
	System.out.println(dir.getAbsolutePath());
	File file = new File(dir, "log_message.txt");
	
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
	pw.println(logMsg);
	pw.flush();
	pw.close();
%>

<h3><%= logMsg %></h3>

</body>
</html>