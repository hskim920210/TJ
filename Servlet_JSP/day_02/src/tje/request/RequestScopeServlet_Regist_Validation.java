package tje.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regist_validation_request")
public class RequestScopeServlet_Regist_Validation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ID : 입력된 값 (유효성 체크 결과)
		// ...
		boolean bIdValid = (Boolean)request.getAttribute("bIdValid");
		boolean bPwValid = (Boolean)request.getAttribute("bPwValid");
		boolean bNameValid = (Boolean)request.getAttribute("bNameValid");
		boolean bAgeValid = (Boolean)request.getAttribute("bAgeValid");
		boolean bTelValid = (Boolean)request.getAttribute("bTelValid");
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		
		StringBuilder buffer = new StringBuilder();
		buffer.append(String.format("<h2>ID : %s (%b)</h2>", 
				request.getParameter("id"), bIdValid));
		buffer.append(String.format("<h2>PW : %s (%b)</h2>", 
				request.getParameter("pw"), bPwValid));
		buffer.append(String.format("<h2>NAME : %s (%b)</h2>", 
				request.getParameter("name"), bNameValid));
		buffer.append(String.format("<h2>AGE : %s (%b)</h2>", 
				request.getParameter("age"), bAgeValid));
		buffer.append(String.format("<h2>TEL : %s (%b)</h2>", 
				request.getParameter("tel"), bTelValid));
		
		out.println(buffer);		
	}
	
}


/* 내가 한것
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter();
		boolean isId, isPw, isName, isAge, isTel;
		
		String strId = (String)request.getAttribute("id");
		String strPw = (String)request.getParameter("pw").trim();
		String strName = (String)request.getParameter("name").trim();
		String strTel = (String)request.getParameter("tel").trim();
		int intAge = -1;


		
		
		if((Boolean)request.getAttribute("isId")) {
			out.println("아이디는 '" + strId + "'입니다.</br>");
		} else {
			out.println("아이디를 다시 확인해주세요. (5~10자)</br>");
		}
		
		if((Boolean)request.getAttribute("isPw")) {
			out.println("비밀번호는 '" + strPw + "'입니다.</br>");
		} else {
			out.println("비밀번호를 다시 확인해주세요. (8~20자)</br>");
		}
		
		if((Boolean)request.getAttribute("isName")) {
			out.println("이름은 '" + strName + "'입니다.</br>");
		} else {
			out.println("이름을 다시 확인해주세요. (3~5자)</br>");
		}
		
		if((Boolean)request.getAttribute("isTel")) {
			out.println("전화번호는 '" + strTel + "'입니다.</br>");
		} else {
			out.println("전화번호를 다시 확인해주세요. (- 제외 11자)</br>");
		}
		
		if((Boolean)request.getAttribute("isAge")) {
			out.println("나이는 '" + intAge + "'입니다.</br>");
		} else {
			out.println("나이를 다시 확인해주세요. (숫자)</br>");
		}
		
		
		if ((Boolean)request.getAttribute("isId") && (Boolean)request.getAttribute("isPw") && (Boolean)request.getAttribute("isName")
				&& (Boolean)request.getAttribute("isTel") && (Boolean)request.getAttribute("isAge")) {
			out.println("<h1><b>회원가입 성공</b></h1>");
		} else {
			out.println("<h1><b>회원가입 실패</b></h1>");
		}
		out.println("<input type = \"button\" onclick = \"location.href='regist_request'\" value = \"돌아가기\"> ");
 */