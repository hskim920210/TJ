package tje.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regist_request")
public class RequestScopeServlet_Regist extends HttpServlet {
	
	public static final String formPage = "/WEB-INF/forms/registForm.html";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(formPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 정보를 request 객체로부터 추출하여 유효성 검증 결과를 
		// RequestScopeServlet_Regist_Validation 서블릿을 통해 응답하기
		// ID의 값은 최소 5글자부터 10글자까지
		// PW의 값은 최소 8글자부터 20글자까지
		// Name의 값은 최소 3글자부터 5글자까지
		// Age의 값은 반드시 숫자만 입력되었는지 확인
		// Tel 정보는 -을 제거한 결과 11글자인지 확인
		
		request.setCharacterEncoding("utf-8");
		
		String strId = request.getParameter("id").trim();
		String strPw = request.getParameter("pw").trim();
		String strName = request.getParameter("name").trim();
		String strAge = request.getParameter("age").trim();
		String strTel = request.getParameter("tel").trim();
		
		boolean bIdValid = false;
		if( strId.length() >= 5 && strId.length() <= 10 )
			bIdValid = true;
		System.out.println(bIdValid);
		boolean bPwValid = false;
		if( strPw.length() >= 8 && strPw.length() <= 20 )
			bPwValid = true;
		
		boolean bNameValid = false;
		if( strName.length() >= 3 && strName.length() <= 5 )
			bNameValid = true;
		
		boolean bAgeValid = false;
		try {
			Integer.parseInt(strAge);
			bAgeValid = true;
		} catch( Exception e ) {
			bAgeValid = false;
		}
		
		boolean bTelValid = false;
		strTel = strTel.replaceAll("-", "");
		if( strTel.length() == 11 )
			bTelValid = true;
		
		// 다른 서블릿에서 유효성 체크 결과를 사용하기 위해서
		// request 객체에 저장
		request.setAttribute("bIdValid", bIdValid);
		request.setAttribute("bPwValid", bPwValid);
		request.setAttribute("bNameValid", bNameValid);
		request.setAttribute("bAgeValid", bAgeValid);
		request.setAttribute("bTelValid", bTelValid);
		
		RequestDispatcher rd = 
				// request.getRequestDispatcher("/regist_validation_request");
				// jsp로 할때
				request.getRequestDispatcher("/WEB-INF/result/registResult.jsp");
		rd.forward(request, response);
	}
}

/* 내가 작성한 것
		boolean isId, isPw, isName, isAge, isTel;
		
		String strId = request.getParameter("id").trim();
		String strPw = request.getParameter("pw").trim();
		String strName = request.getParameter("name").trim();
		String strTel = request.getParameter("tel").trim();
		int intAge = -1;
		
		try {
			intAge = Integer.parseInt(request.getParameter("age").trim());
			isAge = true;
		} catch(NumberFormatException e) {
			isAge = false;
		}
		
		
		if (strId.length() < 5 || strId.length() > 10) {
			isId = false;
		} else {
			isId = true;
		}
		
		if (strPw.length() < 8 || strPw.length() > 20) {
			isPw = false;
		} else {
			isPw = true;
		}
		
		if (strName.length() < 8 || strName.length() > 20) {
			isName = false;
		} else {
			isName = true;
		}
		
		if (strTel.replaceAll("-", "").length() == 11) {
			isTel = true;
		} else {
			isTel = false;
		}
 */