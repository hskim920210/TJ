package tje.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fs_03")
public class FilterServlet_03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie [] cookies = request.getCookies();
		Cookie cookie = null;
		for(int i = 0 ; cookies != null && i < cookies.length ; i++) {
			// name 이란 이름을 가진 쿠키가 있는지 확인한다.
			if( cookies[i].getName().equals("name") ) {
				cookie = cookies[i];
				break;
			}
		}
		
		PrintWriter out = response.getWriter();
		
		if( cookie == null ) {
			out.println("<h3>쿠키가 존재하지 않습니다.</h3>");
		} else {
			out.printf("<h3>쿠키의 값은 %s 입니다.</h3>", cookie.getValue());
			
		}
		
	}
	
}
