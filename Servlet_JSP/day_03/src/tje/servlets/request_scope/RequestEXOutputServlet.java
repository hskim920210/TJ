package tje.servlets.request_scope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request_ex_output")
public class RequestEXOutputServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("<h2>연산 결과</h2>");
		buffer.append(request.getAttribute("output_plus"));
		buffer.append(request.getAttribute("output_minus"));
		buffer.append(request.getAttribute("output_mul"));
		buffer.append(request.getAttribute("output_div"));
		out.println(buffer);
	}
}