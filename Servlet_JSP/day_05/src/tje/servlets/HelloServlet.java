package tje.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	public String printMessage(Date now) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String message = String.format("<h3>안녕하세요. 현재 시간은 %s 입니다.</h3>", sdf.format(now));
		return message;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date now = new Date();
		out.println(printMessage(now));
	}
}
