package tje.servlets.jdbc;

import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.glass.ui.Application;

@WebServlet("/member_login")
public class MemberLoginServlet extends HttpServlet {
	// final 멤버는 생성자에서 초기화하거나 정의할때 초기화할수밖에 없다
	
	private static final String formPage = "/WEB-INF/forms/loginForm.html";
	private static final String errorPage = "/WEB-INF/errors/loginError.html";
	
	private static String jdbc_url;
	private static String jdbc_id;
	private static String jdbc_password;
	
	public void init(ServletConfig config) throws ServletException {
		// 최초에 서블릿이 만들어질 때 어플리케이션에 접근하여 web.xml에 설정한 변수에 접근할 수 있다.
		// config 는 request가 할 수 있는걸 다 가지고 있다. 설정에 관한 것들.
		ServletContext application = config.getServletContext();
		jdbc_url = application.getInitParameter("JDBC_URL");
		jdbc_id = application.getInitParameter("JDBC_ID");
		jdbc_password = application.getInitParameter("JDBC_PASSWORD");
		
		// System.out.println(jdbc_url);
		
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 되어있는지 확인하는 작업.
		// 겟 세션의 매개변수를 false로 두어 세신이 없다면 로그인 안한 클라이언트의 세션을 굳이 안만든다.
		HttpSession session = request.getSession(false);
		// 로그인 되어있는지 불린 타입으로 체크
		boolean isLogin = false;
		if( session != null && session.getAttribute("login_id") != null ) {
			isLogin = true;
		}
		
		// 포워딩 할 페이지를 formPage(loginForm.html)을 디폴트로 잡아놓는다.
		String forwardPage = formPage;
		
		// 로그인이 되어있다면, 로그인 되었다는 메세지가 있는 페이지로 이동.
		if( isLogin ) {
			forwardPage = errorPage;
			
			/*
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder html = new StringBuilder();
			
			html.append("<h3>이미 로그인 되어있습니다.</h3>");
			html.append(String.format("<p><a href='%s'>메인화면으로 이동</a></p>", request.getContextPath() + "/member_main"));
			out.println(html);
			// 버퍼를 비우게되면 포워딩을 할 수 없게되고 리턴까지 해줘야 에러가 없다.
			out.flush();
			return;
			*/
		}
		
		// 로그인이 되었다면 errorPage로, 안되어있다면 formPage로 포워딩 될 것이다.
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// loginForm.html에서 로그인 버튼을 눌렀을 때 post방식으로 전달받아 시행되는 부분
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// loginForm.html의 id와 password는 required 속성을 가지고 있으므로
		// null이 아니다. 바로 trim을 불러도 nullpointerexception 발생하지 않는다.
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		
		//로그인 성공 여부의 값을 저장하는 변수
		boolean isLogin = false;
		
		// JDBC를 사용한 데이터베이스 처리
		// 받아온 id,password가 테이블에 일치하는지 확인하는 작업을 한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(jdbc_url, jdbc_id, jdbc_password);
			String query = "select * from member where id = ? and password = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			// rs.next()가 true면 하나가 조회되었다는 의미.
			// 그럼 로그인 성공여부인 isLogin에 true를 넣어준다.
			if( rs.next() ) {isLogin = true;}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			// 커넥션, 스테이트먼트, 리절트셋 널이 아닌경우 닫아준다.
			if( conn != null ) {conn.close();}
			if( pstmt != null ) {pstmt.close();}
			if( rs != null ) {rs.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 로그인 여부에 따라 작업. html변수에 append 해준다.
		StringBuilder html = new StringBuilder();
		if( isLogin ) { // 로그인 성공했을 때,
			// 현재 로그인된 사용자의 id를 세션의 login_id 속성에 저장
			HttpSession session = request.getSession();
			session.setAttribute("login_id", id);
			
			// 현재 웹 서버(서블릿 컨테이너)에 로그인된 사용자의 수를 증가
			ServletContext application = request.getServletContext();
			
			// application에 동기화는 권장되지 않지만
			// 카운팅을 위해 어쩔수없이 사용한다.
			synchronized (application) {
				// login_member_count 값이 null 이란 뜻은, 아직 아무도 로그인 되어있지 않다는 뜻.
				if(application.getAttribute("login_member_count") == null) {
					application.setAttribute("login_member_count", 1);
				} else {
					Integer count = (Integer)application.getAttribute("login_member_count");
					application.setAttribute("login_member_count", count+1);
				}
			}
			// 카운팅 이후 클라이언트에게 성공메세지를 보여준다.
			html.append("<h3>로그인에 성공했습니다.</h3>");
		} else {
			html.append("<h3>로그인에 실패했습니다.</h3>");
			html.append("<h4>아이디와 패스워드를 확인하세요.</h4>");
		}
		
		html.append(String.format("<p><a href='%s'>메인화면으로 이동</a></p>", request.getContextPath() + "/member_main"));
		out.println(html);
	}
	
}
