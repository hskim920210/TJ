package tje.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.*;
import java.sql.*;

import tje.dao.SimpleArticleDAO;
import tje.jdbc.util.*;
import tje.model.*;
import tje.service.*;


// AJAX를 통한 비동기 호출 방식으로 요청을 수행하는 커맨드 클래스
public class DeleteCommentCommand extends Command {

	private CommentDeleteService cdService = new CommentDeleteService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		// 비동기 통신으로 전달하는 댓글 ID 값 추출
		String strComment_id = request.getParameter("comment_id");
		int  comment_id = Integer.parseInt(strComment_id);
		System.out.println(strComment_id);
		
		// 클라이언트에게 전송할 변수
		boolean result = false;
		try (Connection conn = ConnectionProvider.getConnection()) {
			
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			Comment comment = new Comment();
			comment.setComment_id(comment_id);
			values.put("model", comment);
			
			HashMap<String, Object> resultMap = cdService.service(values);
			// html로 보내는게 아니므로 setAttribute를 하지 않고 result만 설정해준다.
			result = (boolean)resultMap.get("result");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		// 비동기 통신 방법을 사용하여 요청을 처리하는 경우
		// HTML 파일을 반환하는 것이 아닌
		// 일반 텍스트, JSON, XML 형식을 반환하게 된다.
		// 이러한 경우 포워딩을 통한 처리 방식도 가능하지만
		// 아래와 같이 response 객체를 사용하여 
		// 클라이언트에게 즉시 응답하는 코드를 작성할 수 있다.
		response.setContentType("text/plane;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(result);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
